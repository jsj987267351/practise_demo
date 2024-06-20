package LeetCode.month06.day20;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/20 10:03
 */
public class demo4 {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x < 4) return 1;
        int left = 1, right = x / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sum = (long) mid * mid;
            if (sum > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}

