package day2023_04_04.demo5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * @date 2023/4/4 13:03
 * https://leetcode.cn/problems/binary-tree-postorder-traversal/
 */
public class demo {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        zhongxu(root, result);
        return result;
    }

    private void zhongxu(TreeNode root, List<Integer> result) {

        if (root != null) {
            zhongxu(root.left, result);
            zhongxu(root.right, result);
            result.add(root.val);

        }
    }
}

