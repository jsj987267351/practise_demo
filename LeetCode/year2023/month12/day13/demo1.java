package month12.day13;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/13 13:37
 */
public class demo1 {
    public String makeSmallestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length-1;
        while (left < right){
            if (chars[left]!=chars[right]){
                if (chars[left] < chars[right]){
                    chars[right] = chars[left];
                }else {
                    chars[left] = chars[right];
                }
            }
            left++;
            right--;
        }
        return String.valueOf(chars);
    }
}

