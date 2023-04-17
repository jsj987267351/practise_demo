package day26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。

 * 链接：https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array
 * @date 2023/4/17 20:44
 */
public class demo6 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] ints = new int[nums.length +1];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            ints[nums[i]] = 1;
        }

        for (int i = 1; i <ints.length ; i++) {
            if (ints[i] ==0){
                result.add(i);
            }
        }
        return result;
    }

}

