package month10.day24.demo3;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/diameter-of-binary-tree/?envType=list&envId=hliQiQFH
 * @date 2023/10/24 12:59
 */
public class demo3 {
    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return res;
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }
}

