package day2023_05_19;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/5/19 14:31
 */
public class demo1 {
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        int left = 0, right = num / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long value = (long) mid * (long)mid;
            if (value > num) {
                right = mid - 1;
            } else if (value < num) {
                left = mid + 1;
            } else return true;
        }
        return false;
    }
}

