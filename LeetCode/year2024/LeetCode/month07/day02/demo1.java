package LeetCode.month07.day02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/2 9:29
 */
public class demo1 {
    public int maximumPrimeDifference(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (isZhi(nums[i])) {
                list.add(i);
            }
        }
        return list.size() == 1 ? 0 : list.get(list.size() - 1) - list.get(0);
    }

    public boolean isZhi(int num) {
        if (num == 1) return false;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}

