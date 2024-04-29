package LeetCode.month04.day25;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/4/25 11:27
 */
public class demo {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int res = 0;
        while (mainTank > 0) {
            if (mainTank >= 5) {
                res += 50;
                mainTank -= 5;
                if (additionalTank > 0) {
                    mainTank++;
                    additionalTank--;
                }
            } else {
                res += 10;
                mainTank--;
            }
        }
        return res;
    }
}

