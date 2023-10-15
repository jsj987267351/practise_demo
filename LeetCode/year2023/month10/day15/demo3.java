package month10.day15;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/15 13:59
 */
public class demo3 {
    public boolean findTargetIn2DPlants(int[][] plants, int target) {
        int rowLength = plants.length;
        if (rowLength == 0 || plants[0].length == 0) {
            return false;
        }
        int colLength = plants[0].length;
        int row = rowLength - 1, col = 0;
        while (row >= 0 && col < colLength) {
            if (plants[row][col] < target) {
                col++;
            } else if (plants[row][col] > target) {
                row--;
            } else {
                return true;
            }
        }
        return false;
    }
}

