package month12.day04.demo3;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/4 13:22
 */
public class demo3 {
    int res;

    public int distributeCoins(TreeNode root) {
        res = 0;
        moveCoin(root);
        return res;
    }

    public int moveCoin(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = moveCoin(root.left);
        res += Math.abs(left);
        int right = moveCoin(root.right);
        res += Math.abs(right);
        return left + right + root.val - 1;
    }
}

