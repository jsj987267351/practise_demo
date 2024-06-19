package LeetCode.month06.day19.demo3;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/19 10:42
 */
public class demo {

    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return res;
    }

    public int getDepth(TreeNode root){
        if (root == null) return 0;
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        res = Math.max(res,leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}

