package LeetCode.month04.day12;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/4/12 11:27
 */
public class demo {
    public int findChampion(int[][] grid) {
        int length = grid.length;
        for (int i = 0; i < length; i++) {
            boolean flag = true;
            for (int j = 0; j < length; j++) {
                if (i == j) continue;
                if (grid[j][i] == 1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}

