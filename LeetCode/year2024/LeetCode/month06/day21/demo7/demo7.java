package LeetCode.month06.day21.demo7;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/21 10:34
 */
public class demo7 {
    int res = 0;

    public int sumNumbers(TreeNode root) {
        backtracking(root, 0);
        return res;
    }

    public void backtracking(TreeNode root, int preNum) {
//        这里不能用判断root == null 后来加res，是因为一个叶子节点左右都为null，会加两次
        preNum = preNum * 10 + root.val;
        if (root.left == null && root.right == null) {
            res += preNum;
            return;
        }
        if (root.left != null) {
            backtracking(root.left, preNum);
        }
        if (root.right != null) {
            backtracking(root.right, preNum);
        }
        preNum /= 10;
    }
}

