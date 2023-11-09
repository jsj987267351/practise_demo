package month11.day09;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/9 12:46
 */
public class demo4 {
    List<List<Integer>> res;
    LinkedList<Integer> list;

    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        list = new LinkedList<>();
        backtracking(k, n, 0, 1);
        return res;
    }

    public void backtracking(int k, int n, int sum, int startIndex) {
        if (sum > n) {
            return;
        }
        if (sum == n && list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = startIndex; i <= 9 +1 -k + list.size(); i++) {
            list.add(i);
            sum += i;
            backtracking(k, n, sum, i + 1);
            sum -= i;
            list.removeLast();
        }
    }
}

