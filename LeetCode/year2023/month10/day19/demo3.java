package month10.day19;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/uUsW3B/?envType=list&envId=RxT23Yqb
 * @date 2023/10/19 12:31
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

    public void backtracking(int n, int k, int index) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

//        【x, n】的数组长度起码应该是k-path.size()才有继续搜索的可能， 那么就有 n-x+1 = k-path.size()  ， 解方程得 x = n+1 - (k-path.size()), 而且这个x是可以作为起点往下搜的 也就是for(i = s; i<=x; i++) 这里的x是可以取到的
        for (int i = index; i <= n +1 - (k - list.size()); i++) {
            list.add(i);
            backtracking(n, k, i + 1);
            list.removeLast();
        }
    }
}

