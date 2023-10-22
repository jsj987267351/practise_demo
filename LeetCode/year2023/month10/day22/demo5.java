package month10.day22;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/22 12:45
 */
public class demo5 {
    public String addStrings(String num1, String num2) {
        int left = num1.length() - 1, right = num2.length() - 1;
        int temp = 0;
        StringBuilder res = new StringBuilder();
        while (left >= 0 || right >= 0) {
            int sum = 0;
            if (left >= 0) {
                sum += num1.charAt(left) - '0';
                left--;
            }
            if (right >= 0) {
                sum += num2.charAt(right) - '0';
                right--;
            }
            sum += temp;
            res.append(sum % 10);
            temp = sum / 10;
        }
        if (temp == 1) {
            res.append(1);
        }
        return res.reverse().toString();
    }
}

