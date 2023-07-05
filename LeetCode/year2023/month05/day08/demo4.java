package month05.day08;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * https://leetcode.cn/problems/uUsW3B/
 * @date 2023/5/8 17:41
 */
public class demo4 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        backtracking(result, path, n, k,1);
        return result;
    }

    public void backtracking(List<List<Integer>> result, LinkedList<Integer> path, int n, int k,int startIndex){
        if (path.size() ==k){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= n-(k-path.size())+1; i++) {
            path.add(i);

            backtracking(result,path,n,k,i+1);

            path.removeLast();
        }
    }
}

