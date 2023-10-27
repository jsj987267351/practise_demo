package month10.day27;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/27 12:23
 */
public class demo2 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        char[] chars = String.valueOf(x).toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

