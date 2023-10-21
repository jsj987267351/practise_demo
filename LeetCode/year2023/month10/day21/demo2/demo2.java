package month10.day21.demo2;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/sum-of-left-leaves/?envType=list&envId=RxT23Yqb
 * @date 2023/10/21 12:35
 */
public class demo2 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        return help(root);
    }


    public int help(TreeNode root) {
        int res = 0;
        if (root.left != null) {
            if (isBoom(root.left)) {
                res += root.left.val;
            } else {
                res += help(root.left);
            }
        }

        if (root.right != null && !isBoom(root.right)) {
            res += help(root.right);
        }
        return res;
    }

    public boolean isBoom(TreeNode root) {
        return root.left == null && root.right == null;
    }
}

