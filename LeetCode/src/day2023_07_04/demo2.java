package day2023_07_04;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个下标从 0 开始的二维整数数组 nums 。一开始你的分数为 0 。你需要执行以下操作直到矩阵变为空：
 * <p>
 * 矩阵中每一行选取最大的一个数，并删除它。如果一行中有多个最大的数，选择任意一个并删除。
 * 在步骤 1 删除的所有数字中找到最大的一个数字，将它添加到你的 分数 中。
 * 请你返回最后的 分数 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sum-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/4 12:56
 */
public class demo2 {
    public int matrixSum(int[][] nums) {
//        思路：将二维数组的每一行进行降序排序，然后总和相加为每一列的最大值
        int sum = 0;

        int max = 0;
        for (int[] num : nums) {
            Arrays.sort(num);
        }

        for (int col = 0; col < nums[0].length; col++) {
            for (int row = 0; row < nums.length; row++) {
                max = Math.max(max, nums[row][col]);
            }
            sum += max;
            max = 0;
        }

        return sum;
    }
}

