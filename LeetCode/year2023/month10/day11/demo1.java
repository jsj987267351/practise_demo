package month10.day11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/11 11:53
 */
public class demo1 {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
//        暴力解法
//        首先存储每个单词的分值
        Map<String, Integer> map = new HashMap<>();
        for (String s : positive_feedback) {
            map.put(s, 3);
        }
        for (String s : negative_feedback) {
            map.put(s, -1);
        }
//        遍历每个学生的评语后添加对应分数
//        该集合存放的是数组，每个数组大小为2 int[0]表示该名学生的id，int[1]表示改名学生的分数，最后排序返回前k位即可
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < report.length; i++) {
//            该名学生的id
            int id = student_id[i];
//            该名学生的评语
            String pingyu = report[i];
//            统计该名学生评语对应的分数
            int count = 0;
            String[] reports = pingyu.split(" ");
            for (String s : reports) {
                count += map.getOrDefault(s, 0);
            }
            list.add(new int[]{id, count});
        }
        list.sort((a, b) -> b[1] == a[1] ? a[0] - b[0] : b[1] - a[1]);
//        保存最终结果
        List<Integer> res = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            res.add(list.get(i)[0]);
        }
        return res;
    }
}

