package month10.day13;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/find-the-difference/?envType=list&envId=RxT23Yqb
 * @date 2023/10/13 12:08
 */
public class demo3 {
    public char findTheDifference(String s, String t) {
        int[] charsIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charsIndex[s.charAt(i) - 'a']--;
            charsIndex[t.charAt(i) - 'a']++;
        }
        charsIndex[t.charAt(t.length() - 1) - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (charsIndex[i] != 0) {
                return (char) (i + 'a');
            }
        }
        return 'a';
    }
}

