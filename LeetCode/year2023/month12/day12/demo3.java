package month12.day12;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/12 14:10
 */
public class demo3 {
    public int trainingPlan(int[] actions) {
        int[] res = new int[32];
        for (int action : actions) {
            for (int i = 31; i >= 0; i--) {
                res[i] += (action & 1);
                action >>= 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            sum += (res[i] % 3) << (31 - i);
        }
        return sum;
    }

    public int trainingPlan1(int[] actions) {
        int[] res = new int[32];
        for (int action : actions) {
            int temp = 1;
            for (int i = 31; i >= 0; i--) {
                if ((action & temp) != 0) {
                    res[i]++;
                }
                temp <<= 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            sum += (res[i] % 3) << (31 - i);
        }
        return sum;
    }
}

