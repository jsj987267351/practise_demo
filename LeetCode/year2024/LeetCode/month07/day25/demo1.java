package LeetCode.month07.day25;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/25 9:31
 */
public class demo1 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int happy = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                happy += customers[i];
                customers[i] = 0;
            }
        }
        int cur = 0, max = 0;
        for (int i = 0; i < customers.length; i++) {
            cur += customers[i];
            if (i >= minutes) {
                cur -= customers[i - minutes];
            }
            max = Math.max(max, cur);
        }
        return happy + max;
    }
}

