package month09.day20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/9/20 13:21
 */
public class demo3 {
    public List<List<Integer>> pairSums(int[] nums, int target) {
//    排序后双指针
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int left = 0, right = nums.length - 1;
//        同一个数字只能用1次，所以这里不能用<=
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(nums[left]);
                list.add(nums[right]);
                res.add(list);
                left++;
                right--;
            }
        }
        return res;
    }
}

