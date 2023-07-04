package day2023_05_15;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * https://leetcode.cn/problems/spiral-matrix/
 * @date 2023/5/15 17:47
 */
public class demo2 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int left = 0, right = matrix[0].length - 1, high = 0, low = matrix.length - 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[high][i]);
            }
            if (++high >low) break;
            for (int i = high; i <= low; i++) {
                result.add(matrix[i][right]);
            }
            if (--right < left) break;
            for (int i = right; i >= left; i--) {
                result.add(matrix[low][i]);
            }
            if (--low<high) break;
            for (int i = low; i >= high; i--) {
                result.add(matrix[i][left]);
            }
            if (++left >right) break;
        }
        return result;
    }
}

