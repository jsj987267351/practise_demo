package LeetCode.month06.day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/16 14:43
 */
public class demo6 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b)->a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> list = new ArrayList<>();
        for (int[] person : people) {
            list.add(person[1],person);
        }
        return list.toArray(new int[list.size()][]);
    }
}

