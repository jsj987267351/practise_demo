package month12.day22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/22 14:15
 */
public class demo2 {
    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int leftNum = nums[left];
            int rightNum = nums[right];
            int sum = leftNum + rightNum;
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                res.add(Arrays.asList(leftNum, rightNum));
                left++;
                right--;
            }
        }
        return res;
    }
}

