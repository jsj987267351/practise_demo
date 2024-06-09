package LeetCode.month06.day09;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/9 18:26
 */
public class demo7 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        int[] path = new int[numRows];
        for (int i = 0; i < numRows; i++) {
            help(path, i);
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                cur.add(path[j]);
            }
            res.add(cur);
        }
        return res;
    }

    public void help(int[] path, int numRows) {
        if (numRows == 0) {
            path[0] = 1;
            return;
        }
        for (int i = numRows; i > 0; i--) {
            path[i] += path[i - 1];
        }
    }
}

