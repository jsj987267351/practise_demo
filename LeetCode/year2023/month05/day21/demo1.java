package month05.day21;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定两个字符串 s 和 t ，它们只包含小写字母。
 * <p>
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * <p>
 * 请找出在 t 中被添加的字母。
 * https://leetcode.cn/problems/find-the-difference/
 * @date 2023/5/21 14:37
 */
public class demo1 {
    public  char findTheDifference1(String s, String t) {
//        定义小写字母的数组，判断数量即可
        int[] ints = new int[26];
        int[] intt = new int[26];

        for (int i = 0; i < s.length(); i++) {
            ints[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            intt[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (ints[i] + 1 == intt[i]) {
                return (char) (i + 'a');
            }
        }
        return t.charAt(0);
    }

    public  char findTheDifference(String s, String t) {
//        计算两个字符串的ascii码总值，最后二者的差值就是多出来的
        int as = 0 , at = 0;
        for (int i = 0; i < s.length(); i++) {
            as+=s.charAt(i) - 'a';
        }
        for (int i = 0; i < t.length(); i++) {
            at+=t.charAt(i) - 'a';
        }

        return (char) (at - as + 'a');
    }
}

