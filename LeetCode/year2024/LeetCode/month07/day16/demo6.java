package LeetCode.month07.day16;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/16 10:42
 */
public class demo6 {
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] mask = new int[len];
        for (int i = 0; i < words.length; i++) {
            int tmp = 0;
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                tmp |= 1 << word.charAt(j) - 'a';
            }
            mask[i] = tmp;
        }
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}

