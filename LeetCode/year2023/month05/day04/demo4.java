package month05.day04;

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
 * 注意：答案中不可以包含重复的三元组。
 * 链接：https://leetcode.cn/problems/3sum
 * @date 2023/5/4 16:28
 */
public class demo4 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;

        if (length < 3) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int numI = nums[i];
            if (numI > 0) {
                return result;
            }
            if (i > 0 && numI == nums[i - 1]) continue;
            int L = i+1;
            int R = length-1;
            while (L <R){
                int sum = numI + nums[L] + nums[R];
                if (sum ==0){
                    List<Integer> list = new ArrayList<>();
                    list.add(numI);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    result.add(list);

                    while (L < R && nums[L] ==nums[L+1]){
                        L++;
                    }
                    while (L < R && nums[R] ==nums[R-1]){
                        R--;
                    }
                    L++;
                    R--;
                }else if (sum>0){
                    R--;
                }else {
                    L++;
                }
            }
        }
        return result;
    }
}

