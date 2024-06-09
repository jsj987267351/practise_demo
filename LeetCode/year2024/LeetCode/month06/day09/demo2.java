package LeetCode.month06.day09;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/9 17:46
 */
public class demo2 {
    public String addBinary(String a, String b) {
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        StringBuilder res = new StringBuilder();
        int indexa = aa.length - 1, indexb = bb.length - 1, sum = 0;
        while (indexa >= 0 || indexb >= 0 || sum > 0) {
            if (indexa >= 0) {
                sum += aa[indexa--] - '0';
            }
            if (indexb >= 0) {
                sum += bb[indexb--] - '0';
            }
            res.append(sum % 2);
            sum /= 2;
        }
        return res.reverse().toString();
    }
}

