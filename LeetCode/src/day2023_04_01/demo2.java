package day2023_04_01;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 * @date 2023/4/1 20:28
 * https://leetcode.cn/problems/single-number/
 */
public class demo2 {
    public int singleNumber1(int[] nums) {
        int[] zheng = new int[3 * 10 * 10 * 10 * 10 + 1];
        int[] fu = new int[3 * 10 * 10 * 10 * 10 + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                zheng[nums[i]]++;
            } else {
                fu[Math.abs(nums[i])]++;
            }
        }
        for (int i = 0; i < zheng.length; i++) {
            if (zheng[i] == 1) {
                return i;
            }
        }
        for (int i = 0; i < fu.length; i++) {
            if (fu[i] == 1) {
                return i - 2 * i;
            }
        }
        return 0;
    }

    public int singleNumber2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ) {
            if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i += 2;
            } else {
                return nums[i];
            }
        }
        return 0;
    }

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> result = new HashMap<>();
        for (int num : nums) {
            Integer a = result.get(num);
            if (a == null) {
                result.put(num, 1);
            } else {
                result.put(num, a+1);
            }
        }
        for (Integer key : result.keySet()) {
            Integer a = result.get(key);
            if (a == 1) {
                return key;
            }
        }
        return -1;
    }

}

