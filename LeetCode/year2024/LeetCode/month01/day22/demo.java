package LeetCode.month01.day22;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/22 10:37
 */
public class demo {
    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            int maxIdx = i;
            for (int j = length - 1; j >= i + 1; j--) {
                if (chars[j] > chars[maxIdx]) {
                    maxIdx = j;
                }
            }
            if (maxIdx != i) {
                char temp = chars[i];
                chars[i] = chars[maxIdx];
                chars[maxIdx] = temp;
                return Integer.parseInt(String.valueOf(chars));
            }
        }
        return num;
    }
}

