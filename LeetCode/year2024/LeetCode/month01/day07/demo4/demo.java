package LeetCode.month01.day07.demo4;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/7 15:20
 */
public class demo {
    int res;

    public int pseudoPalindromicPaths(TreeNode root) {
        res = 0;
        backtracking(root, 0);
        return res;
    }

    public void backtracking(TreeNode root, int num) {
        num ^= (1 << root.val);
        if (root.left == null && root.right == null) {
            if (Integer.bitCount(num) < 2) {
                res++;
            }
            return;
        }
        if (root.left != null) {
            backtracking(root.left, num);
        }
        if (root.right != null) {
            backtracking(root.right, num);
        }
        num ^= (1 << root.val);
    }
}

