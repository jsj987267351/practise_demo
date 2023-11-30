package month11.day30;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/30 11:39
 */
public class demo1 {
    public boolean closeStrings(String word1, String word2) {
//        长度不一致返回false
        if (word1.length() != word2.length()) {
            return false;
        }
//        两个字符串出现的字符种类不一致也返回false
        int[] ints1 = new int[26];
        int[] ints2 = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            ints1[word1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < word2.length(); i++) {
            ints2[word2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
//            说明该字母有一个字符串中不包含，返回false
            if (ints1[i] == 0 && ints2[i] != 0 || ints1[i] != 0 && ints2[i] == 0) {
                return false;
            }
        }
//        因为每两个字母的数量可以交换，也就代表着所有的字母各自出现的数量都可以随意交换。所以两个字符串的字母出现频率的组合相等即可true
        Arrays.sort(ints1);
        Arrays.sort(ints2);
        return Arrays.equals(ints1,ints2);
    }
}

