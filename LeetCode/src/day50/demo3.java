package day50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/5/24 16:33
 */
public class demo3 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        int length = nums.length;
//        遍历到length-3即可，因为要求长度为4
        for (int one = 0; one < length-3; one++) {
//            重复的直接跳过
            if (one > 0 && nums[one] == nums[one - 1]) continue;
//            判断当前位置的最小值
            long min = (long) nums[one] + nums[one + 1] + nums[one + 2] + nums[one + 3];
//            如果最小值都比target大，后续就没有继续的必要了
            if (min > target) break;
//            判断当前位置的最大值，
            long max = (long) nums[one] + nums[length - 1] + nums[length - 2] + nums[length - 3];
//            如果最大值都比target小，则需要continue,不能break，因为排序后是升序的，后续的最大值会越来越大
            if (max < target) continue;
//          第二层循环
            for (int two = one + 1; two < length-2; two++) {
                if (two > one + 1 && nums[two - 1] == nums[two]) continue;
//                后续遍历区间
                int three = two + 1, four = length - 1;
                long min2 = (long) nums[one] + nums[two] + nums[three] + nums[three + 1];
                if (min2 > target) break;
                long max2 = (long) nums[one] + nums[two] + nums[four] + nums[four - 1];
                if (max2 < target) continue;

                while (three < four) {
                    long sum = (long) nums[one] + nums[two] + nums[three] + nums[four];
                    if (sum == target) {
//                        找到目标
                        result.add(Arrays.asList(nums[one], nums[two], nums[three], nums[four]));
//                        两端移到不相等的下标上
                        while (three < four && nums[three] == nums[three + 1]) three++;
                        while (three < four && nums[four] == nums[four - 1]) four--;
                        three++;
                        four--;
                    } else if (sum > target) {
                        four--;
                    } else {
                        three++;
                    }
                }
            }
        }
        return result;
    }


}

