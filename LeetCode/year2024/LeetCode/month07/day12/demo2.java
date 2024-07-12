package LeetCode.month07.day12;

import java.util.*;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/12 9:31
 */
public class demo2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> needPreCourseCount = new HashMap<>();
        Map<Integer, List<Integer>> preCourses = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            needPreCourseCount.put(i, 0);
        }
        for (int[] prerequisite : prerequisites) {
            int cur = prerequisite[0];
            int pre = prerequisite[1];
            needPreCourseCount.put(cur, needPreCourseCount.get(cur) + 1);
            if (!preCourses.containsKey(pre)) {
                preCourses.put(pre, new ArrayList<>());
            }
            preCourses.get(pre).add(cur);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (Integer key : needPreCourseCount.keySet()) {
            if (needPreCourseCount.get(key) == 0) {
                queue.add(key);
            }
        }
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            if (!preCourses.containsKey(cur)) continue;
            List<Integer> list = preCourses.get(cur);
            for (Integer key : list) {
                needPreCourseCount.put(key, needPreCourseCount.get(key) - 1);
                if (needPreCourseCount.get(key) == 0) {
                    queue.add(key);
                }
            }
        }
        for (int value : needPreCourseCount.values()) {
            if (value != 0) return false;
        }
        return true;
    }
}

