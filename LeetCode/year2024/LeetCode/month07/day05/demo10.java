package LeetCode.month07.day05;

import java.util.*;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/5 10:51
 */
public class demo10 {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);
        Set<String> positive = new HashSet<>(Arrays.asList(positive_feedback));
        Set<String> negative = new HashSet<>(Arrays.asList(negative_feedback));
        for (int i = 0; i < report.length; i++) {
            int id = student_id[i];
            String[] pingYu = report[i].split(" ");
            int score = 0;
            for (String s : pingYu) {
                if (positive.contains(s)) {
                    score += 3;
                } else if (negative.contains(s)) {
                    score -= 1;
                }
            }
            minHeap.offer(new int[]{id, score});
        }
        List<Integer> res = new ArrayList<>();
        while (k-- > 0) {
            res.add(minHeap.poll()[0]);
        }
        return res;
    }
}

