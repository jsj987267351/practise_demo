package month09.day20;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/sum-swap-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/9/20 12:57
 */
public class demo2 {
    public int[] findSwapValues(int[] array1, int[] array2) {
        int sum1 = 0, sum2 = 0;
        for (int num : array1) {
            sum1 += num;
        }
        for (int num : array2) {
            sum2 += num;
        }
//        总和为奇数的话不可能平分
        if ((sum1 + sum2) % 2 != 0) {
            return new int[0];
        }

        Set<Integer> set = new HashSet<>();
        for (int num : array1) {
            set.add(num);
        }
        int[] res = new int[2];
//        根据列公式求出两个数组中差值为 target得即可正常交换
//        sum1 - x1 + y1 = sum2 -y1 + x1  => (sum1 - sum2) /2 = x1 - y1
        int target = (sum1 - sum2) / 2;
        for (int i = 0; i < array2.length; i++) {
            if (set.contains(target + array2[i])) {
                res[0] = target + array2[i];
                res[1] = array2[i];
                return res;
            }
        }
        return new int[0];
    }
}

