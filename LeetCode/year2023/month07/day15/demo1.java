package month07.day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * <p>
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/15 18:29
 */
public class demo1 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int one = 0; one < length - 3; one++) {
            if (one > 0 && nums[one] == nums[one - 1]) {
                continue;
            }
            long minOne = (long) nums[one] + nums[one + 1] + nums[one + 2] + nums[one + 3];
            if (minOne > target) {
                break;
            }
            long maxOne = (long) nums[one] + nums[length - 1] + nums[length - 2] + nums[length - 3];
            if (maxOne < target) {
                continue;
            }
            for (int two = one + 1; two < length - 2; two++) {
                if (two > one + 1 && nums[two] == nums[two - 1]) {
                    continue;
                }
                long minTwo = (long) nums[one] + nums[two] + nums[two + 1] + nums[two + 2];
                if (minTwo > target) {
                    break;
                }
                long maxTwo = (long) nums[one] + nums[two] + nums[length - 1] + nums[length - 2];
                if (maxTwo < target) {
                    continue;
                }
                int three = two + 1, four = length - 1;
                while (three < four) {
                    long num = (long) nums[one] + nums[two] + nums[three] + nums[four];
                    if (num == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[one]);
                        list.add(nums[two]);
                        list.add(nums[three]);
                        list.add(nums[four]);
                        res.add(list);
                        while (three < four && nums[three] == nums[three + 1]) {
                            three++;
                        }
                        while (three < four && nums[four] == nums[four - 1]) {
                            four--;
                        }
                        four--;
                        three++;
                    } else if (num > target) {
                        four--;
                    } else {
                        three++;
                    }
                }
            }
        }
        return res;
    }
}

