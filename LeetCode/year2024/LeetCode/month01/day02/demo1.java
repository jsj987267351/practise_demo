package LeetCode.month01.day02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/2 12:11
 */
public class demo1 {
    public List<String> computeSimilarities(int[][] docs) {
        List<String> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int rowLength = docs.length;
        int[][] union = new int[rowLength][rowLength];
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < docs[row].length; col++) {
                int num = docs[row][col];
                List<Integer> list = map.get(num);
                if (list == null) {
                    list = new ArrayList<>();
                    map.put(num, list);
                } else {
                    for (int RowIndex : list) {
                        union[RowIndex][row]++;
                    }
                }
                list.add(row);
            }
            for (int preRow = 0; preRow < row; preRow++) {
                if (union[preRow][row] > 0) {
                    res.add(preRow + "," + row + ": " + String.format("%.4f", (double) union[preRow][row] / (docs[preRow].length + docs[row].length - union[preRow][row])));
                }
            }
        }
        return res;
    }
}

