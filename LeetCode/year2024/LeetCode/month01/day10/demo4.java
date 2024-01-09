package LeetCode.month01.day10;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/9 14:52
 */
public class demo4 {
    public int maxProduct(String[] words) {
        int length = words.length;
        int[] mask = new int[length];
        for (int i = 0; i < length; i++) {
            String cur = words[i];
            for (int j = 0; j < cur.length(); j++) {
                mask[i] = mask[i] | (1 << cur.charAt(j) - 'a');
            }
        }
        int res = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}

