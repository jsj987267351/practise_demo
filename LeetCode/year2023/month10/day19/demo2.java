package month10.day19;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/search-in-rotated-sorted-array/description/?envType=list&envId=RxT23Yqb
 * @date 2023/10/19 12:21
 */
public class demo2 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == target) return left;
            if (nums[right] == target) return right;
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;

            if (nums[mid] < nums[right]) {
                if (nums[mid] < target && nums[right] > target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[mid] > target && nums[left] < target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}

