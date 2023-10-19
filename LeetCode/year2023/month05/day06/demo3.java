package month05.day06;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * https://leetcode.cn/problems/combinations/
 * @date 2023/5/6 16:41
 */
public class demo3 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n < k) {
            return result;
        }

        LinkedList<Integer> path = new LinkedList<>();
        backtracking(result, path, n, k, 1);
        return result;
    }


    public void backtracking(List<List<Integer>> result, LinkedList<Integer> path, int n, int k, int startIndex) {
//        中止条件
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
//        【x, n】的数组长度起码应该是k-path.size()才有继续搜索的可能， 那么就有 n-x+1 = k-path.size()  ， 解方程得 x = n+1 - (k-path.size()), 而且这个x是可以作为起点往下搜的 也就是for(i = s; i<=x; i++) 这里的x是可以取到的
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.offer(i);
            backtracking(result, path, n, k, i + 1);
            path.removeLast();
        }
    }


}

