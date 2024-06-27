package LeetCode.month06.day27;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/27 11:09
 */
public class demo9 {
    int rowLength;
    int colLength;


    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rowLength = image.length;
        colLength = image[0].length;
        backtracking(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    public void backtracking(int[][] image, int row, int col, int color, int target) {
        if (row < 0 || row >= rowLength || col < 0 || col >= colLength || image[row][col] != target || image[row][col] == color) return;
        image[row][col] = color;
        backtracking(image, row - 1, col, color, target);
        backtracking(image, row + 1, col, color, target);
        backtracking(image, row, col - 1, color, target);
        backtracking(image, row, col + 1, color, target);
    }
}

