package month10.day26;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/26 11:11
 */
public class demo1 {
    public int countDigits(int num) {
        int res = 0, sum = num;
        while (num != 0) {
            int temp = num % 10;
            if (sum % temp == 0) {
                res++;
            }
            num /= 10;
        }
        return res;
    }
}

