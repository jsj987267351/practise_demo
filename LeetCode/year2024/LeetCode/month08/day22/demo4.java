package LeetCode.month08.day22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/8/22 10:44
 */
public class demo4 {
    public List<Integer> partitionLabels1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int right = 0, left = 0;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(right, map.get(s.charAt(i)));
            if (i == right) {
                res.add(right - left + 1);
                left = right +1;
            }
        }
        return res;
    }

    public List<Integer> partitionLabels(String s) {
        int[] map = new int[26];
        int right = 0, left = 0;
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) -'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(right, map[s.charAt(i) - 'a']);
            if (i == right) {
                res.add(right - left + 1);
                left = right +1;
            }
        }
        return res;
    }
}

