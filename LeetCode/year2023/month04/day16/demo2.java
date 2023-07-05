package month04.day16;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * https://leetcode.cn/problems/is-unique-lcci/
 * @date 2023/4/16 19:56
 */
public class demo2 {
    public boolean isUnique(String astr) {
        int[] ints = new int[26];
        for (int i = 0; i < astr.length(); i++) {
            ints[astr.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (ints[i] >1){
                return false;
            }
        }
        return true;
    }
}

