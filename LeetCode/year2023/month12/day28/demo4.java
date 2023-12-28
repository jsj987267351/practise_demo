package month12.day28;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/28 13:16
 */
public class demo4 {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : positive_feedback) {
            map.put(s, 3);
        }
        for (String s : negative_feedback) {
            map.put(s, -1);
        }
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < report.length; i++) {
            int id = student_id[i];
            int score = 0;
            String s = report[i];
            String[] pingYu = s.split(" ");
            for (String word : pingYu) {
                score += map.getOrDefault(word, 0);
            }
            list.add(new int[]{id, score});
        }
        list.sort((a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(list.get(i)[0]);
        }
        return res;
    }
}

