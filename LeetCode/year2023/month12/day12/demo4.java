package month12.day12;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/12 14:25
 */
public class demo4 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        help(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    public void help(int[][] image, int sr, int sc, int newColor, int target) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != target || image[sr][sc] == newColor) {
            return;
        }
        image[sr][sc] = newColor;
        help(image, sr, sc - 1, newColor, target);
        help(image, sr - 1, sc, newColor, target);
        help(image, sr, sc + 1, newColor, target);
        help(image, sr + 1, sc, newColor, target);
    }
}

