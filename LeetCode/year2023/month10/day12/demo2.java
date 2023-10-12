package month10.day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/4sum/?envType=list&envId=hliQiQFH
 * @date 2023/10/12 12:07
 */
public class demo2 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int one = 0; one < len - 3; one++) {
            if (one > 0 && nums[one] == nums[one - 1]) continue;
            long min1 = (long) nums[one] + nums[one + 1] + nums[one + 2] + nums[one + 3];
            if (min1 > target) {
                break;
            }
            long max1 = (long) nums[one] + nums[len - 1] + nums[len - 2] + nums[len - 3];
            if (max1 < target) continue;
            for (int two = one + 1; two < len - 2; two++) {
                if (two > one + 1 && nums[two] == nums[two - 1]) continue;
                long min2 = (long) nums[one] + nums[two] + nums[two + 1] + nums[two + 2];
                if (min2 > target) {
                    break;
                }
                long max2 = (long) nums[one] + nums[two] + nums[len - 1] + nums[len - 2];
                if (max2 < target) continue;
                int three = two + 1, four = len - 1;
                while (three < four) {
                    long num = nums[one] + nums[two] + nums[three] + nums[four];
                    if (num < target) {
                        three++;
                    } else if (num > target) {
                        four--;
                    } else {
                        res.add(Arrays.asList(nums[one], nums[two], nums[three], nums[four]));
                        while (three < four && nums[three] == nums[three + 1]) {
                            three++;
                        }
                        while (three < four && nums[four] == nums[four - 1]) {
                            four--;
                        }
                        three++;
                        four--;
                    }
                }
            }
        }
        return res;
    }
}

