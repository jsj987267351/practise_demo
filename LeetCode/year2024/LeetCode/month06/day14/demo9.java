package LeetCode.month06.day14;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/14 15:05
 */
public class demo9 {
    public int monotoneIncreasingDigits(int n) {
        char[] charArray = String.valueOf(n).toCharArray();
        int index = charArray.length;
        for (int i = charArray.length - 2; i >= 0; i--) {
            if (charArray[i] > charArray[i + 1]) {
                index = i + 1;
                charArray[i]--;
            }
        }
        for (int i = index; i < charArray.length ; i++) {
            charArray[i] = '9';
        }
        return Integer.parseInt(String.valueOf(charArray));
    }
}

