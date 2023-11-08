package month11.day08.demo6;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/8 13:56
 */
public class demo6 {
    int afterSum;

    public TreeNode convertBST(TreeNode root) {
        afterSum = 0;
        help(root);
        return root;
    }

    public void help(TreeNode root) {
        if (root == null) return;
        help(root.right);
        root.val += afterSum;
        afterSum = root.val;
        help(root.left);
    }
}

