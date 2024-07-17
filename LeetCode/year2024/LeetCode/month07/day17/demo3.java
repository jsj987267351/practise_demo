package LeetCode.month07.day17;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/17 10:07
 */
public class demo3 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int index = 1, left = 0, top = 0, right = n - 1, bottom = n - 1;
        while (index <= n * n) {
            for (int col = left; col <= right; col++) {
                res[top][col] = index++;
            }
            top++;
            for (int row = top; row <= bottom; row++) {
                res[row][right] = index++;
            }
            right--;
            for (int col = right; col >= left; col--) {
                res[bottom][col] = index++;
            }
            bottom--;
            for (int row = bottom; row >= top; row--) {
                res[row][left] = index++;
            }
            left++;
        }
        return res;
    }
}

