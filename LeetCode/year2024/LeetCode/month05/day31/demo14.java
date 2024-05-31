package LeetCode.month05.day31;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/5/31 14:31
 */
public class demo14 {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int length = grid.length;
        int[] count = new int[length * length + 1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                count[grid[i][j]]++;
            }
        }
        int[] res = new int[2];
        for (int i = 1; i < length * length + 1; i++) {
            if (count[i] == 0) {
                res[1] = i;
            }
            if (count[i] == 2) {
                res[0] = i;
            }
        }
        return res;
    }
}

