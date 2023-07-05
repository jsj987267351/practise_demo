package month04.day04.demo3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * @date 2023/4/4 12:35
 * https://leetcode.cn/problems/middle-of-the-linked-list/
 */
public class demo {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        add(root, result);
        return result;
    }

    public void add(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            add(root.left,result);
            add(root.right,result);
        }
    }
}

