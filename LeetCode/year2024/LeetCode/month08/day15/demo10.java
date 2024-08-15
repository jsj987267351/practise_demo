package LeetCode.month08.day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/8/15 11:15
 */
public class demo10 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int one = 0; one < len - 2; one++) {
            if (one > 0 && nums[one] == nums[one - 1]) continue;
            int minOne = nums[one] + nums[one + 1] + nums[one + 2];
            if (minOne > 0) break;
            int maxOne = nums[one] + nums[len - 1] + nums[len - 2];
            if (maxOne < 0) continue;
            int two = one + 1, three = len - 1;
            while (two < three) {
                int cur = nums[one] + nums[two] + nums[three];
                if (cur < 0) {
                    while (two < three && nums[two] == nums[two + 1]) {
                        two++;
                    }
                    two++;
                } else if (cur > 0) {
                    while (two < three && nums[three] == nums[three - 1]) {
                        three--;
                    }
                    three--;
                } else {
                    res.add(Arrays.asList(nums[one], nums[two], nums[three]));
                    while (two < three && nums[two] == nums[two + 1]) {
                        two++;
                    }
                    while (two < three && nums[three] == nums[three - 1]) {
                        three--;
                    }
                    two++;
                    three--;
                }
            }
        }
        return res;
    }
}

