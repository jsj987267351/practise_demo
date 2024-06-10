package LeetCode.month06.day10;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/10 17:17
 */
public class demo8 {
    public List<Integer> partitionLabels(String s) {
        int[] need = new int[26];
        int left = 0, right = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            need[cur - 'a'] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(right, need[s.charAt(i) - 'a']);
            if (i == right) {
                res.add(right - left + 1);
                left = right + 1;
            }
        }
        return res;
    }
}

