package LeetCode.month06.day14;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/14 14:24
 */
public class demo3 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1);
        return res;
    }

    public void backtracking(int k, int n, int index) {
        if (path.size() > k || n < 0) return;
        if (n == 0 && path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i <= 9; i++) {
            path.add(i);
            backtracking(k, n - i, i + 1);
            path.removeLast();
        }
    }
}

