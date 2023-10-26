package month10.day26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/3sum/?envType=list&envId=hliQiQFH
 * @date 2023/10/26 12:08
 */
public class demo6 {
    List<List<Integer>> res;

    public List<List<Integer>> threeSum(int[] nums) {
        res = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);

        for (int one = 0; one < len - 2; one++) {
            if (nums[one] > 0) break;
            if (one > 0 && nums[one] == nums[one - 1]) continue;
            int curMin = nums[one] + nums[one + 1] + nums[one + 2];
            if (curMin > 0) break;
            int curMax = nums[one] + nums[len - 1] + nums[len - 2];
            if (curMax < 0) continue;
            int two = one + 1, three = len - 1;
            while (two < three) {
                int num = nums[one] + nums[two] + nums[three];
                if (num > 0) {
                    three--;
                } else if (num < 0) {
                    two++;
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

