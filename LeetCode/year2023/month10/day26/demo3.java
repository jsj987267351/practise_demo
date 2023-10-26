package month10.day26;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/combinations/description/?envType=list&envId=hliQiQFH
 * @date 2023/10/26 11:45
 */
public class demo3 {
    List<List<Integer>> res;
    LinkedList<Integer> list;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        list = new LinkedList<>();
        backtracking(n, k, 1);
        return res;
    }

    public void backtracking(int n, int k, int startIndex) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = startIndex; i <= n - k + list.size() + 1; i++) {
            list.add(i);
            backtracking(n, k, i + 1);
            list.removeLast();
        }
    }
}

