package LeetCode.month07.day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/4 10:22
 */
public class demo5 {
    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int left = 0, right = nums.length - 1;
        Arrays.sort(nums);
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                res.add(Arrays.asList(nums[left], nums[right]));
                left++;
                right--;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }
}

