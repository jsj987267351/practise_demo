package LeetCode.month01.day09;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/9 15:01
 */
public class demo6 {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int rowLength = mat.length;
        int colLength = mat[0].length;
        int[] row = new int[rowLength];
        int[] col = new int[colLength];
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int[] cur = map.get(arr[i]);
            if (++row[cur[0]] ==colLength || ++col[cur[1]] == rowLength){
                return i;
            }
        }
        return -1;
    }
}

