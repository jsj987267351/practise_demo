package LeetCode.month04.day30;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/4/30 12:17
 */
public class demo {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int res = 0;
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] >= target) res++;
        }
        return res;
    }
}

