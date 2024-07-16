package LeetCode.month07.day16;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/16 10:47
 */
public class demo7 {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, int[]> map = new HashMap<>();
        int rowLength = mat.length;
        int colLength = mat[0].length;
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                map.put(mat[row][col], new int[]{row, col});
            }
        }
        int[] rowCount = new int[rowLength];
        int[] colCount = new int[colLength];
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            int[] ints = map.get(cur);
            rowCount[ints[0]]++;
            colCount[ints[1]]++;
            if (rowCount[ints[0]] == colLength || colCount[ints[1]] == rowLength) {
                return i;
            }
        }
        return -1;
    }
}

