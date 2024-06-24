package LeetCode.month06.day24;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/24 11:40
 */
public class demo9 {
    public String compressString(String S) {
        int left = 0, right = 0;
        StringBuilder res = new StringBuilder();
        char[] charArray = S.toCharArray();
        while (right < S.length()) {
            while (right < S.length() && charArray[right] == charArray[left]) {
                right++;
            }
            res.append(charArray[left]).append(right - left);
            left = right;
        }
        return res.length() < S.length() ? res.toString() : S;
    }
}

