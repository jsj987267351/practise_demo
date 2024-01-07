package LeetCode.month01.day08;

import java.util.Collections;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/7 15:15
 */
public class demo3 {
    public int countPairs(List<Integer> nums, int target) {
        int left = 0, right = nums.size() - 1, res = 0;
        Collections.sort(nums);
        while (left < right) {
            if (nums.get(left) + nums.get(right) < target) {
                res += right - left;
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}

