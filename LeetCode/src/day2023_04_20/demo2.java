package day2023_04_20;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 * <p>
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 链接：https://leetcode.cn/problems/word-pattern
 * @date 2023/4/20 18:18
 */
public class demo2 {
    public boolean wordPattern(String pattern, String s) {
        String[] s1 = s.split(" ");
        if (pattern.length() != s1.length) {
            return false;
        }
        Map<Object, Integer> map = new HashMap<>();
//        如果key不存在，插入成功，返回null；如果key存在，返回之前对应的value。
        for (Integer i = 0; i < s1.length; i++) {
            if (map.put(pattern.charAt(i), i)!=map.put(s1[i], i)) {
                return false;
            }
        }
        return true;
    }


}

