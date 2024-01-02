package LeetCode.month01.day02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/2 13:00
 */
public class demo4 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        int length = s.length();
        if (length < 10) {
            return res;
        }
        Map<String, Integer> map = new HashMap<>();
        int left = 0, right = 10;
        while (right <= length) {
            String curString = s.substring(left, right);
            map.put(curString, map.getOrDefault(curString, 0) + 1);
            if (map.get(curString) == 2){
                res.add(curString);
            }
            left++;
            right++;
        }
        return res;
    }
}

