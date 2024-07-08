package LeetCode.month07.day08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/8 10:49
 */
public class demo9 {
    public static void main(String[] args) {
        String s = "CAAAAAAAAAC";
        findRepeatedDnaSequences(s);
    }
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 10) return res;
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < 10; i++) {
            sb.append(charArray[i]);
        }
        map.put(sb.toString(), 1);
        for (int i = 10; i <charArray.length ; i++) {
            sb.append(charArray[i]);
            String substring = sb.substring(i - 9, i+1);
            map.put(substring, map.getOrDefault(substring, 0) + 1);
        }
        for (String key : map.keySet()) {
            if (map.get(key) >1){
                res.add(key);
            }
        }
        return res;
    }
}

