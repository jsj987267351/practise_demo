package LeetCode.month02.day10;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/2/10 10:00
 */
public class demo {
    List<Integer> res;

    public List<Integer> inorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        help(root);
        return res;
    }

    public void help(TreeNode root) {
        if (root != null) {
            help(root.left);
            res.add(root.val);
            help(root.right);
        }
    }
}

