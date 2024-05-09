package LeetCode.month05.day03;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/5/3 12:09
 */
public class demo {
    public double average(int[] salary) {
        int len = salary.length;
        Arrays.sort(salary);
        double res = 0;
        for (int i = 1; i <len -1; i++) {
            res+=salary[i];
        }
        return res /(len -2);
    }
}

