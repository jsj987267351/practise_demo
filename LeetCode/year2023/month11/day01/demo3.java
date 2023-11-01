package month11.day01;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/1 13:22
 */
public class demo3 {
    public int mySqrt(int x) {
        if (x == 0) {
            return x;
        }
        if (x <= 3) {
            return 1;
        }
//        判断那里不可以用乘法，因为会溢出
        int left = 1, right = x / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }
}
