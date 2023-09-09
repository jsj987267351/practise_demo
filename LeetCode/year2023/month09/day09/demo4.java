package month09.day09;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/9/9 14:09
 */
public class demo4 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtracking(list, n, n, sb);
        return list;
    }

    public void backtracking(List<String> list, int leftSize, int rightSize, StringBuilder sb) {
        if (leftSize == 0 && rightSize == 0) {
            list.add(sb.toString());
            return;
        }
        if (leftSize > rightSize) {
            return;
        }

        if (leftSize > 0) {
            sb.append("(");
            backtracking(list, leftSize - 1, rightSize, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (rightSize > 0) {
            sb.append(")");
            backtracking(list, leftSize, rightSize - 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

