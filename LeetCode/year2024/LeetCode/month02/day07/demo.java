package LeetCode.month02.day07;

import java.util.ArrayList;
import java.util.List;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/2/7 10:45
 */
public class demo {
    public TreeNode replaceValueInTree(TreeNode root) {
        root.val = 0;
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<TreeNode> temp = queue;
            queue = new ArrayList<>();
            int nextSum = 0;
            for (TreeNode treeNode : temp) {
                if (treeNode.left != null) {
                    nextSum += treeNode.left.val;
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    nextSum += treeNode.right.val;
                    queue.add(treeNode.right);
                }
            }
            for (TreeNode treeNode : temp) {
                int childrenSum = (treeNode.left != null ? treeNode.left.val : 0) + (treeNode.right != null ? treeNode.right.val : 0);
                if (treeNode.left != null) treeNode.left.val = nextSum - childrenSum;
                if (treeNode.right != null) treeNode.right.val = nextSum - childrenSum;
            }
        }
        return root;
    }
}

