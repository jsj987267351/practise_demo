package month11.day24;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/24 13:18
 */
public class demo5 {
    public int findPeakElement(int[] nums) {
//        使用二分法直接相当于找最大值
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int findPeakElement1(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 && nums[i] > nums[i + 1] || i == nums.length - 1 && nums[i] > nums[i - 1] || nums[i] > nums[i + 1] && nums[i] > nums[i - 1]) {
                return i;
            }
        }
        return 0;
    }
}

