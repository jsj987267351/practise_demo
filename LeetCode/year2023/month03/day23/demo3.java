package month03.day23;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 * https://leetcode.cn/problems/valid-anagram/
 */
public class demo3 {
    public boolean isAnagram(String s, String t) {
        int length1 = s.length();
        int length2 = t.length();
        if (length1 != length2) {
            return false;
        }
        int[] ints = new int[26];
        int[] intt = new int[26];
        for (int i = 0; i < 26; i++) {
            ints[i] = 0;
            intt[i] = 0;
        }
        for (int i = 0; i < length1; i++) {
            ints[s.charAt(i) - 'a']++;
            intt[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if(ints[i] != intt[i]){
                return false;
            }
        }
        return true;
    }
}
