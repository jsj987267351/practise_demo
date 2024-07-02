package LeetCode.month07.day02.demo6;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/2 10:33
 */
public class demo {
    int res = 0;

    public int distributeCoins(TreeNode root) {
        moveCoins(root);
        return res;
    }

    public int moveCoins(TreeNode root) {
        if (root == null) return 0;
        int left = moveCoins(root.left);
        int right = moveCoins(root.right);
        res += Math.abs(left) + Math.abs(right);
        return left + right + root.val - 1;
    }
}

