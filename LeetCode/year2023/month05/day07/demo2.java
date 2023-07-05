package month05.day07;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * @date 2023/5/7 15:58
 */
public class demo2 {
    public int[][] findContinuousSequence(int target) {
        int left = 1;
        int right = 1;
        int sum = 0;

        List<int[]> list = new ArrayList<>();

        while (left <= target/2) {
            if (sum > target) {
                sum -= left;
                left++;
            } else if (sum < target) {
                sum += right;
                right++;
            }else {
                int[] ints = new int[right - left];
                for (int i = left; i <right ; i++) {
                    ints[i-left] = i;
                }
                list.add(ints);
                sum-=left;
                left++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}

