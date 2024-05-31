package LeetCode.month05.day31;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/5/31 13:52
 */
public class demo11 {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        int left = 0, right = num / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sum = (long) mid * mid;
            if (sum == num) {
                return true;
            } else if (sum < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}

