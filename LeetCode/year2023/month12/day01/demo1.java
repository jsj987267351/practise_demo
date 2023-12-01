package month12.day01;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/1 12:22
 */
public class demo1 {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int rowLength = mat.length;
        int colLength = mat[0].length;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }
//        代表每一行和每一列已经有多少被涂过了
        int[] rowSum = new int[rowLength];
        int[] colSum = new int[colLength];
        for (int i = 0; i < arr.length; i++) {
            int[] ints = map.get(arr[i]);
            int row = ints[0];
            int col = ints[1];
            if (++rowSum[row] == colLength || ++colSum[col] == rowLength) {
                return i;
            }
        }
        return -1;
    }
}

