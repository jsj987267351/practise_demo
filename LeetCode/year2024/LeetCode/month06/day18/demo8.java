package LeetCode.month06.day18;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/18 13:59
 */
public class demo8 {
    List<String> res;
    StringBuilder sb;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        sb = new StringBuilder();
        backtracking(n, n);
        return res;
    }

    public void backtracking(int left, int right) {
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        if (left > right) return;
        if (left > 0) {
            sb.append('(');
            backtracking(left - 1, right);
            sb.deleteCharAt(sb.length() - 1);

        }
        if (right > 0) {
            sb.append(')');
            backtracking(left, right - 1);
            sb.deleteCharAt(sb.length() - 1);

        }
    }
}

