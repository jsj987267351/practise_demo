package month04.day10;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 * https://leetcode.cn/problems/add-binary/
 * @date 2023/4/10 15:53
 */
public class demo1 {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int temp = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = temp;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            result.append(sum % 2);
            temp = sum / 2;
        }
        if (temp == 1){
            result.append(1);
        }
        return result.reverse().toString();
    }
}

