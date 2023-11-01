package month11.day01;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/1 13:38
 */
public class demo4 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}

