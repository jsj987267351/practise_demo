package month12.day28;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/28 13:10
 */
public class demo3 {
    public int splitNum(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        Arrays.sort(chars);
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i% 2 == 0) {
                sum1 = sum1 * 10 + chars[i] - '0';
            } else {
                sum2 = sum2 * 10 + chars[i] - '0';
            }
        }
        return sum1 + sum2;
    }
}

