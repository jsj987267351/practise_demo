package month11.day29.demo2;

import java.time.Period;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/29 17:06
 */
public class demo2 {
    int res;

    public int sumNumbers(TreeNode root) {
        res = 0;
        backtracking(root, 0);
        return res;
    }

    public void backtracking(TreeNode root, int preValue) {
        preValue = preValue * 10 + root.val;
        if (root.left == null && root.right == null) {
            res += preValue;
            return;
        }
        if (root.left != null) {
            backtracking(root.left, preValue);
        }
        if (root.right != null) {
            backtracking(root.right, preValue);
        }
        preValue = preValue / 10;
    }
}

