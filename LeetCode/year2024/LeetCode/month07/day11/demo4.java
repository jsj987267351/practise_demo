package LeetCode.month07.day11;

import java.util.Collections;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/11 10:17
 */
public class demo4 {
    public int countPairs(List<Integer> nums, int target) {
        int res = 0;
        Collections.sort(nums);
        int left = 0, right = nums.size() - 1;
        while (left < right) {
            if (nums.get(left) + nums.get(right) >= target) {
                right--;
            } else {
                res += (right - left);
                left++;
            }
        }
        return res;
    }
}

