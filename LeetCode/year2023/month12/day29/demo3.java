package month12.day29;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/29 13:15
 */
public class demo3 {
    public int[] getMaxMatrix(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int[][] preSum = new int[rowLength + 1][colLength + 1];
        for (int row = 1; row <= rowLength; row++) {
            for (int col = 1; col <= colLength; col++) {
                preSum[row][col] = matrix[row - 1][col - 1] + preSum[row - 1][col] + preSum[row][col - 1] - preSum[row - 1][col - 1];
            }
        }
        int[] res = new int[4];
        int max = Integer.MIN_VALUE;
        for (int top = 0; top < rowLength; top++) {
            for (int bottom = top; bottom < rowLength; bottom++) {
                int localMax = 0, left = 0;
                for (int right = 0; right < colLength; right++) {
                    localMax = preSum[bottom + 1][right + 1] - preSum[bottom + 1][left] - preSum[top][right + 1] + preSum[top][left];
                    if (localMax > max) {
                        max = localMax;
                        res[0] = top;
                        res[1] = left;
                        res[2] = bottom;
                        res[3] = right;
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

