package LeetCode.month06.day18.demo9;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/18 14:04
 */
public class demo {
    List<String> res;
    StringBuilder sb;

    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        sb = new StringBuilder();
        backtracking(root);
        return res;
    }

    public void backtracking(TreeNode root) {
        if (root == null) return;
        int len = sb.length();
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
        }
        sb.append("->");
        backtracking(root.left);
        backtracking(root.right);
        sb.delete(len, sb.length());
    }
}

