package month11.day21;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/21 15:17
 */
public class demo3 {
    public int stockManagement(int[] stock) {
        int left = 0, right = stock.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (stock[mid] < stock[right]) {
//                右边递增
                right = mid;
            } else if (stock[mid] > stock[right]) {
//                左边递增
                left = mid +1;
            }else {
                right--;
            }
        }
        return stock[left];
    }
}

