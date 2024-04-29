package LeetCode.month04.day29;

import java.util.*;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/4/29 12:06
 */
public class demo {
    public int[][] diagonalSort(int[][] mat) {
        int colLength = mat[0].length;
        int rowLength = mat.length;
//        key 行与列的差值，也就是对角线，value为对角线上的值
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                int value = row - col;
                if (!map.containsKey(value)) {
                    map.put(value, new ArrayList<>());
                }
                map.get(value).add(mat[row][col]);
            }
        }
        for (List<Integer> value : map.values()) {
            Collections.sort(value);
        }

        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                int value = row - col;
                List<Integer> list = map.get(value);
                mat[row][col] = list.get(0);
                list.remove(0);
            }
        }
        return mat;
    }
}

