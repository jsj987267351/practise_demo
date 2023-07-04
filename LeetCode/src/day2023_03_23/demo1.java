package day2023_03_23;

/**
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 * https://leetcode.cn/problems/first-unique-character-in-a-string/
 */
public class demo1 {
    public int firstUniqChar(String s) {
        int index = -1;
        int length = s.length();
        if (length == 1) {
            return 0;
        }
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    continue;
                }
                if (s.charAt(j) != c) {
                    index = i;
                    continue;
                }
                if (s.charAt(j) == c) {
                    index = -1;
                    break;
                }
            }
            if (index != -1) {
                return index;
            }
        }
        return index;
    }
}
