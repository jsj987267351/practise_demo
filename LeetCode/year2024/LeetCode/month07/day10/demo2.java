package LeetCode.month07.day10;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/10 9:56
 */
public class demo2 {
    public int[] getMaxMatrix(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int[][] preSum = new int[rowLength + 1][colLength + 1];
        for (int row = 1; row <= rowLength; row++) {
            for (int col = 1; col <= colLength; col++) {
                preSum[row][col] = preSum[row - 1][col] + preSum[row][col - 1] - preSum[row - 1][col - 1] + matrix[row - 1][col - 1];
            }
        }
        int maxArea = Integer.MIN_VALUE;
        int[] res = new int[4];
        for (int top = 1; top <= rowLength; top++) {
            for (int bottom = top; bottom <= rowLength; bottom++) {
                int left = 1, localMax = 0;
                for (int right = 1; right <= colLength; right++) {
                    localMax = preSum[bottom][right] - preSum[bottom][left - 1] - preSum[top - 1][right] + preSum[top - 1][left - 1];
                    if (localMax > maxArea) {
                        maxArea = localMax;
                        res[0] = top - 1;
                        res[1] = left - 1;
                        res[2] = bottom - 1;
                        res[3] = right - 1;
                    }
                    if (localMax < 0) {
                        left = right + 1;
                    }
                }
            }
        }
        return res;
    }
}

