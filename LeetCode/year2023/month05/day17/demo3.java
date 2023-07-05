package month05.day17;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * https://leetcode.cn/problems/spiral-matrix-ii/
 * @date 2023/5/17 17:29
 */
public class demo3 {
    public int[][] generateMatrix1(int n) {
        int[][] result = new int[n][n];
        int left = 0, right = n - 1, top = 0, low = n - 1, num = 1;
        while (true) {
//            从左到右
            for (int i = left; i <= right; i++) {
                result[top][i] = num++;
            }
            if (++top > low) break;
//            从上到下
            for (int i = top; i <= low; i++) {
                result[i][right] = num++;
            }
            if (--right < left) break;
//            从右到左
            for (int i = right; i >= left; i--) {
                result[low][i] = num++;
            }
            if (--low < top) break;
//            从下到上
            for (int i = low; i >= top; i--) {
                result[i][left] = num++;
            }
            if (++left > right) break;
        }
        return result;
    }

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int left = 0, right = n - 1, top = 0, low = n - 1, num = 1,sum = n*n;
        while (num <=sum) {
//            从左到右
            for (int i = left; i <= right; i++) {
                result[top][i] = num++;
            }
            top++;
//            从上到下
            for (int i = top; i <= low; i++) {
                result[i][right] = num++;
            }
            right--;
//            从右到左
            for (int i = right; i >= left; i--) {
                result[low][i] = num++;
            }
            low--;
//            从下到上
            for (int i = low; i >= top; i--) {
                result[i][left] = num++;
            }
            left++;
        }
        return result;
    }
}

