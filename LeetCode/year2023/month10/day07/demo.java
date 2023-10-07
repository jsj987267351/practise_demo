package month10.day07;

import java.util.*;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/course-schedule/solutions/250377/bao-mu-shi-ti-jie-shou-ba-shou-da-tong-tuo-bu-pai-/?envType=study-plan-v2&envId=top-100-liked
 * @date 2023/10/7 13:22
 */
public class demo {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
//       主要看题解中 笨猪爆破组的解析
//        首先找出每个入度为0的点，意味着这些点可以直接学习，不需要前置课程，加入队列。
//        并且统计每个点的所有前置课程，如果该课程的所有前置课程学习过了，即该点的入度为0时。那么该课程也就可以进行学习了
//        学习key课程需要学习value个前置课程
        Map<Integer, Integer> preCourseCounts = new HashMap<>();
//        首先给所有课程的前置课程数置0
        for (int i = 0; i < numCourses; i++) {
            preCourseCounts.put(i, 0);
        }
//        value集合中的所有课程的前置课程都有key
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
//            当前要学习的课程
            int next = prerequisite[0];
//            想要学习当前课程需要先学习cur课程
            int cur = prerequisite[1];
//            学习当前课程需要的前置课程数+1
            preCourseCounts.put(next, preCourseCounts.get(next) + 1);
//            并且记录所有以cur课程为前置课程的集合
            if (!adj.containsKey(cur)) {
                adj.put(cur, new ArrayList<>());
            }
            adj.get(cur).add(next);
        }

//        存储入度为0的所有课程，也就是不需要前置课程可以直接学习的课程
        Queue<Integer> queue = new LinkedList<>();
        for (Integer key : preCourseCounts.keySet()) {
            if (preCourseCounts.get(key) == 0) {
                queue.offer(key);
            }
        }

//        开始学习
        while (!queue.isEmpty()) {
//            当前可以学习的课程，学习了该课程后，所有以该课程为前置课程的课程的入度-1
            int cur = queue.poll();
//            如果没有以当前课程为前置课程的课程，直接跳过
            if (!adj.containsKey(cur)){
                continue;
            }
//            所有以cur课程为前置课程的课程
            List<Integer> list = adj.get(cur);
            for (Integer index : list) {
                preCourseCounts.put(index, preCourseCounts.get(index) - 1);
//                如果当前课程的入度为0了，代表该课程的所有前置课程都学完了，可以进行学习了，加入待学习队列
                if (preCourseCounts.get(index) == 0) {
                    queue.offer(index);
                }
            }
        }

//        遍历所有课程的入度是否为0，如果还有为0的则代表该课程还未学习，也就是无法完成整体课程
        for (Integer key : preCourseCounts.keySet()) {
            if (preCourseCounts.get(key) != 0) {
                return false;
            }
        }
        return true;
    }
}

