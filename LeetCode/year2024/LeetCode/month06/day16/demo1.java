package LeetCode.month06.day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/16 13:48
 */
public class demo1 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int one = 0; one < len - 3; one++) {
            if (one > 0 && nums[one - 1] == nums[one]) continue;
            long maxOne = (long)nums[one] + nums[len -1] + nums[len -2] + nums[len -3];
            if (maxOne < target) continue;
            long minOne = (long)nums[one] + nums[one +1] + nums[one +2] + nums[one +3];
            if (minOne > target) break;
            for (int two = one + 1; two < len - 2; two++) {
                if (two > one + 1 && nums[two - 1] == nums[two]) continue;
                long max = (long)nums[one] + nums[two] + nums[len - 1] + nums[len - 2];
                if (max < target) continue;
                long min = (long)nums[one] + nums[two] + nums[two + 1] + nums[two + 2];
                if (min > target) break;
                int left = two + 1, right = len - 1;
                while (left < right) {
                    long sum = nums[one] + nums[two] + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[one], nums[two], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }else if (sum > target){
                        right--;
                    }else {
                        left++;
                    }
                }
            }
        }
        return res;
    }
}

