package month07.day09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * <p>
 * 你返回所有和为 0 且不重复的三元组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/9 18:44
 */
public class demo1 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;

        Arrays.sort(nums);
        for (int one = 0; one < length - 2; one++) {
            int numOne = nums[one];
            if (numOne > 0) {
                return res;
            }
            if (one > 0 && nums[one] == nums[one - 1]) {
                continue;
            }
            int two = one + 1;
            if (numOne + nums[two] + nums[two + 1] > 0) {
                return res;
            }
            int three = length - 1;
            while (two < three) {
                int num = numOne + nums[two] + nums[three];
                if (num == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(numOne);
                    list.add(nums[two]);
                    list.add(nums[three]);
                    res.add(list);

                    while (two < three && nums[two] == nums[two + 1]) {
                        two++;
                    }
                    while (two < three && nums[three] == nums[three - 1]) {
                        three--;
                    }
                    two++;
                    three--;
                } else if (num > 0) {
                    three--;
                } else {
                    two++;
                }
            }
        }
        return res;
    }
}

