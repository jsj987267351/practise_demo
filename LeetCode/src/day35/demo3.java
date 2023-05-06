package day35;


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
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n < k) {
            return result;
        }

        LinkedList<Integer> path = new LinkedList<>();
        backtracking(result, path, n, k, 1);
        return result;
    }


    public static void backtracking(List<List<Integer>> result, LinkedList<Integer> path, int n, int k, int startIndex) {
//        中止条件
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= n; i++) {
            path.offer(i);
            backtracking(result, path, n, k, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 2);
        System.out.println(combine);
    }
}

