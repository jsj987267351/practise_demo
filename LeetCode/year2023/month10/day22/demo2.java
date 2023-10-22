package month10.day22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/22 12:09
 */
public class demo2 {
    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtracking(n, n, sb);
        return res;
    }

    public void backtracking(int leftNum, int rightNum, StringBuilder sb) {
        if (leftNum == 0 && rightNum == 0) {
            res.add(sb.toString());
            return;
        }

        if (leftNum > rightNum) {
            return;
        }

        if (leftNum > 0) {
            sb.append("(");
            backtracking(leftNum - 1, rightNum, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (rightNum > 0) {
            sb.append(")");
            backtracking(leftNum, rightNum - 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

