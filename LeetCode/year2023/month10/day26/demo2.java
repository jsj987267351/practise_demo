package month10.day26;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/?envType=list&envId=hliQiQFH
 * @date 2023/10/26 11:28
 */
public class demo2 {
    public int[][] fileCombination(int target) {
        List<int[]> res = new ArrayList<>();
//        左闭右开,窗口规则要同时满足包括left与不包括right，初始不包括right 所以sum =0
        int left = 1, right = 1, sum = 0;
        while (left <= target / 2) {
            if (sum < target) {
                sum += right;
                right++;
            } else if (sum > target) {
                sum -= left;
                left++;
            } else {
                int[] temp = new int[right - left];
                for (int i = left; i < right; i++) {
                    temp[i - left] = i;
                }
                res.add(temp);
                sum -= left;
                left++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}

