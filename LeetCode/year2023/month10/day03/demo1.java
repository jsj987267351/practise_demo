package month10.day03;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/max-submatrix-lcci/description/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/10/3 13:07
 */
public class demo1 {
    public int[] getMaxMatrix(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
//        前缀和，指以（0，0）为矩阵的左上角，当前下标为矩阵的右下角，得出矩阵中的所有数字之和
        int[][] preSum = new int[rowLength][colLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (i == 0 && j == 0) {
                    preSum[i][j] = matrix[i][j];
                } else if (i == 0) {
//                    第一行的前缀和就是当前值加上前一列的前缀和
                    preSum[i][j] = preSum[i][j - 1] + matrix[i][j];
                } else if (j == 0) {
//                    第一列同理
                    preSum[i][j] = preSum[i - 1][j] + matrix[i][j];
                } else {
//                    否则的话前缀和就等于当前值加上上和左的前缀和之和再减去公共部分，因为公共部分加了两次，可画图理解
                    preSum[i][j] = matrix[i][j] + preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1];
                }
            }
        }
        int[] res = new int[4];
        int Max = Integer.MIN_VALUE;
//         首先固定上下行
        for (int top = 0; top < rowLength; top++) {
//            下行一定要大于上行
            for (int bottom = top; bottom < rowLength; bottom++) {
//            固定当前上下行后求出最大值，固定左侧
                int localMax = 0, left = 0;
                for (int right = 0; right < colLength; right++) {
//                    此时已经固定了上下左右四个点，根据前缀和求出当前矩阵中的数字和,可画图理解
                    if (top > 0 && left > 0) {
                        localMax = preSum[bottom][right] + preSum[top - 1][left - 1] - preSum[top - 1][right] - preSum[bottom][left - 1];
                    } else if (top > 0) {
                        localMax = preSum[bottom][right] - preSum[top - 1][right];
                    } else if (left > 0) {
                        localMax = preSum[bottom][right] - preSum[bottom][left - 1];
                    } else {
                        localMax = preSum[bottom][right];
                    }
//                    如果大则更新
                    if (localMax > Max) {
                        Max = localMax;
                        res[0] = top;
                        res[1] = left;
                        res[2] = bottom;
                        res[3] = right;
                    }
//                    贪心算法，如果固定当前左侧前缀和已经小于0了的话，说明当前右侧这一列的和为较大负数，所以直接跳过当前列
                    if (localMax < 0) {
                        localMax = 0;
                        left = right + 1;
                    }
                }
            }
        }
        return res;
    }
}

