package LeetCode.month08.day22;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/8/22 11:09
 */
public class demo7 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1);
        return res;
    }

    public void backtracking(int k, int n, int index) {
        if (path.size() > k || n < 0) return;
        if (path.size() == k && n == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i <= 9; i++) {
            path.add(i);
            backtracking(k,n-i,i+1);
            path.removeLast();
        }
    }
}

