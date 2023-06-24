package day69;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * <p>
 * 只使用数字1到9
 * 每个数字 最多使用一次 
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/6/24 14:31
 */
public class demo1 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        backtracking(res, path, k, n, 0, 1);
        return res;
    }

    public void backtracking(List<List<Integer>> res, LinkedList<Integer> path, int k, int n, int sum, int startIndex) {
        if (sum > n) {
            return;
        }
        if (sum == n && path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

//        for (int i = startIndex; i <= 9; i++) {
//            path.add(i);
//            sum += i;
//            backtracking(res, path, k, n, sum, i + 1);
//            sum -= i;
//            path.removeLast();
//        }
//          剪枝操作
        for (int i = startIndex; i <= 9 - (k - path.size()) +1; i++) {
            path.add(i);
            sum += i;
            backtracking(res, path, k, n, sum, i + 1);
            sum -= i;
            path.removeLast();
        }
    }
}

