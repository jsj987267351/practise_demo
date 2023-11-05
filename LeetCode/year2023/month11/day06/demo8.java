package month11.day06;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/5 18:35
 */
public class demo8 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int res = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                res = Math.min(res, nums[mid]);
                right = mid - 1;
            } else {
                res = Math.min(res, nums[left]);
                left = mid + 1;
            }
        }
        return res;
    }
}

