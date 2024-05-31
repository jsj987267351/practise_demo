package LeetCode.month05.day31;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/5/31 13:49
 */
public class demo10 {
    public boolean findTargetIn2DPlants(int[][] plants, int target) {
        int row = plants.length - 1, col = 0;
        while (row >= 0 && col < plants[0].length) {
            int value = plants[row][col];
            if (value == target) {
                return true;
            } else if (value < target) {
                col++;
            } else {
                row--;
            }
        }
        return false;
    }
}

