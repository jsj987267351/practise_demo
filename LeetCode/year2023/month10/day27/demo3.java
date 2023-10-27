package month10.day27;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/27 12:25
 */
public class demo3 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                break;
            }
        }
        if (digits[0] != 0) {
            return digits;
        } else {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
    }
}

