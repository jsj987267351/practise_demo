package month10.day16;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/valid-perfect-square/?envType=list&envId=RxT23Yqb
 * @date 2023/10/16 13:03
 */
public class demo2 {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        int left = 0, right = num / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long temp = (long) mid * mid;
            if (temp > num) {
                right = mid - 1;
            } else if (temp < num) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}

