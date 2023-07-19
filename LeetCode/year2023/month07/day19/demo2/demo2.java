package month07.day19.demo2;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * https://leetcode.cn/problems/ping-heng-er-cha-shu-lcof/?envType=study-plan-v2&envId=coding-interviews
 * @date 2023/7/19 15:24
 */
public class demo2 {
    public boolean isBalanced(TreeNode root) {
        return help(root) != -1;
    }

    public int help(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = help(root.left);
        if (left == -1) {
            return -1;
        }
        int right = help(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}

