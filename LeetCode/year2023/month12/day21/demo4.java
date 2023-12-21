package month12.day21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/21 15:11
 */
public class demo4 {
    int rowLength;
    int colLength;

    public int[] pondSizes(int[][] land) {
        List<Integer> list = new ArrayList<>();
        rowLength = land.length;
        colLength = land[0].length;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (land[i][j] == 0) {
                    list.add(getArea(land, i, j));
                }
            }
        }
        int size = list.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = list.get(i);
        }
        Arrays.sort(res);
        return res;
    }

    public int getArea(int[][] land, int row, int col) {
        if (row < 0 || col < 0 || row >= rowLength || col >= colLength || land[row][col] != 0) {
            return 0;
        }
        int area = 1;
        land[row][col] = -1;
        area += getArea(land, row, col - 1);
        area += getArea(land, row - 1, col - 1);
        area += getArea(land, row - 1, col);
        area += getArea(land, row - 1, col + 1);
        area += getArea(land, row, col + 1);
        area += getArea(land, row + 1, col + 1);
        area += getArea(land, row + 1, col);
        area += getArea(land, row + 1, col - 1);
        return area;
    }
}

