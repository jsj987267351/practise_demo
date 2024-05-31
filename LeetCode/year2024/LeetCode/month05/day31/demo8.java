package LeetCode.month05.day31;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/5/31 13:28
 */
public class demo8 {
    public String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i += 2 * k) {
            swap(charArray, i, Math.min(i + k -1 , charArray.length - 1));
        }
        return String.valueOf(charArray);
    }


    public void swap(char[] charArray, int left, int right) {
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
    }
}

