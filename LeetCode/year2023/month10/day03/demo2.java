package month10.day03;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/3 14:10
 */
public class demo2 {
    public int[] getMaxMatrix(int[][] matrix) {
//      与demo1同理，只不过demo1需要多次判断left和top的边界，所以这里直接使用大一圈的矩阵，最上和最左为0
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
//        前缀和，指以（0，0）为矩阵的左上角，当前下标为矩阵的右下角，得出矩阵中的所有数字之和
        int[][] preSum = new int[rowLength + 1][colLength + 1];
        for (int i = 1; i < rowLength + 1; i++) {
            for (int j = 1; j < colLength + 1; j++) {
                preSum[i][j] = matrix[i -1][j -1] + preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1];
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
//                    这里因为preSum的下标缘故，原先需要-1的现在不需要动，原先需要不动的现在需要+1
                    localMax = preSum[bottom + 1][right + 1] + preSum[top][left] - preSum[top][right + 1] - preSum[bottom + 1][left];
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

