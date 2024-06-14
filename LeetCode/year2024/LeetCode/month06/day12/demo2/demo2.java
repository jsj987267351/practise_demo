package LeetCode.month06.day12.demo2;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/12 13:25
 */
public class demo2 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return targetSum == root.val;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}

