package LeetCode.month01.day14;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/14 13:06
 */
public class demo {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 25; i >= 0; i--) {
            int next = i - 1;
            while (true) {
                for (int j = 0; j < repeatLimit && count[i] > 0; j++) {
                    count[i]--;
                    res.append((char) (i + 'a'));
                }
                if (count[i] == 0) {
                    break;
                }
                while (next >= 0 && count[next] == 0) {
                    next--;
                }
                if (next < 0) {
                    break;
                }
                count[next]--;
                res.append((char) (next + 'a'));
            }
        }
        return res.toString();
    }
}

