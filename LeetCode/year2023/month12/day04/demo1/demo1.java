package month12.day04.demo1;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/4 13:05
 */
public class demo1 {
    int preSum;

    public TreeNode bstToGst(TreeNode root) {
        preSum = 0;
        help(root);
        return root;
    }

    public void help(TreeNode root) {
        if (root != null) {
            help(root.right);
            root.val += preSum;
            preSum = root.val;
            help(root.left);
        }
    }
}

