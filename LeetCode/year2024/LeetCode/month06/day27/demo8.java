package LeetCode.month06.day27;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/27 11:00
 */
public class demo8 {
    public int trainingPlan(int[] actions) {
        int[] count = new int[32];
        for (int action : actions) {
            int index = 31;
            while (index >= 0) {
                count[index--] += (action & 1);
                action >>= 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int num = count[i] % 3;
            res += num << 31 - i;
        }
        return res;
    }
}

