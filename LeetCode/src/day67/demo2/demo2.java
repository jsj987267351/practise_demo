package day67.demo2;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * <p>
 * 差值是一个正数，其数值等于两值之差的绝对值。
 * <p>
 * https://leetcode.cn/problems/minimum-absolute-difference-in-bst/
 * @date 2023/6/20 14:49
 */
public class demo2 {
    public int getMinimumDifference1(TreeNode root) {
        int res = Integer.MAX_VALUE;
        return help(root, res);
    }

    private int help(TreeNode root, int res) {
        if (root == null)
            return res;
        if (root.left != null) {
            TreeNode leftMax = root.left;
            while (leftMax.right != null) {
                leftMax = leftMax.right;
            }
            res = Math.min(res, Math.abs(root.val - leftMax.val));
        }
        if (root.right != null) {
            TreeNode rightMin = root.right;
            while (rightMin.left != null) {
                rightMin = rightMin.left;
            }
            res = Math.min(res, Math.abs(root.val - rightMin.val));
        }
        int left = help(root.left, res);
        int right = help(root.right, res);
        return Math.min(left, right);
    }
//    直接中序遍历一直更新即可
    TreeNode pre;
    int res = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if (root == null){
            return 0;
        }
       getMin(root);
        return res;
    }

    private void getMin(TreeNode root) {
        if (root ==null) return;
        getMin(root.left);
        if (pre!=null){
            res = Math.min(res,root.val - pre.val);
        }
        pre = root;
        getMin(root.right);
    }

}


