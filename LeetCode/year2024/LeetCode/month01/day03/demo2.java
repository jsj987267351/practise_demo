package LeetCode.month01.day03;

import java.util.*;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/3 13:32
 */
public class demo2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> preCourseCounts = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            preCourseCounts.put(i, 0);
        }
//        以key课程的前置课程为value
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int cur = prerequisite[0];
            int pre = prerequisite[1];
            preCourseCounts.put(cur, preCourseCounts.get(cur) + 1);
            if (!adj.containsKey(pre)) {
                adj.put(pre, new ArrayList<>());
            }
            adj.get(pre).add(cur);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int key : preCourseCounts.keySet()) {
            if (preCourseCounts.get(key) == 0) {
                queue.add(key);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (!adj.containsKey(cur)) continue;
            List<Integer> list = adj.get(cur);
            for (int key : list) {
                preCourseCounts.put(key, preCourseCounts.get(key) - 1);
                if (preCourseCounts.get(key) == 0) {
                    queue.add(key);
                }
            }
        }
        for (int key : preCourseCounts.keySet()) {
            if (preCourseCounts.get(key) != 0) {
                return false;
            }
        }
        return true;
    }
}

