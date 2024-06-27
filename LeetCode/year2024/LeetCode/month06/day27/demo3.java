package LeetCode.month06.day27;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/27 9:45
 */
public class demo3 {
    public int stockManagement(int[] stock) {
        int left = 0, right = stock.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (stock[mid] < stock[right]) {
                right = mid;
            } else if (stock[mid] > stock[right]) {
                left = mid +1;
            } else right--;
        }
        return stock[left];
    }
}

