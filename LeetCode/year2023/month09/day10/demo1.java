package month09.day10;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/color-fill-lcci/description/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/9/10 12:25
 */
public class demo1 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        help(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    public void help(int[][] image, int sr, int sc, int newColor, int target) {
//            特判
        if (sr >= image.length || sc >= image[0].length || sc < 0 || sr < 0 || image[sr][sc] != target || image[sr][sc] == newColor) {
            return;
        }
        image[sr][sc] = newColor;
//        上右下左
        help(image, sr - 1, sc, newColor, target);
        help(image, sr, sc + 1, newColor, target);
        help(image, sr + 1, sc, newColor, target);
        help(image, sr, sc - 1, newColor, target);
    }
}

