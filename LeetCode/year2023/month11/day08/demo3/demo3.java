package month11.day08.demo3;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/8 13:21
 */
public class demo3 {
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        help(root);
        return max;
    }

//    建议看官方解析更清晰易懂
    public int help(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(help(root.left), 0);
        int right = Math.max(help(root.right), 0);
        int curSum = root.val + left + right;
        max = Math.max(max, curSum);
        return root.val + Math.max(left, right);
    }
}

