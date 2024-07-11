package LeetCode.month07.day11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/11 9:45
 */
public class demo2 {
    public List<String> computeSimilarities(int[][] docs) {
        List<String> res = new ArrayList<>();
        int len = docs.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[][] unionCount = new int[len][len];
        for (int row = 0; row < len; row++) {
            for (int col = 0; col < docs[row].length; col++) {
                int cur = docs[row][col];
                List<Integer> list = map.get(cur);
                if (list == null) {
                    list = new ArrayList<>();
                    map.put(cur, list);
                } else {
                    for (int index : list) {
                        unionCount[row][index]++;
                    }
                }
                list.add(row);
            }
            for (int preRow = 0; preRow < row; preRow++) {
                if (unionCount[row][preRow] > 0) {
                    res.add(preRow + "," + row + ": " + String.format("%.4f", (double) unionCount[row][preRow] / (docs[preRow].length + docs[row].length - unionCount[row][preRow])));
                }
            }
        }
        return res;
    }
}

