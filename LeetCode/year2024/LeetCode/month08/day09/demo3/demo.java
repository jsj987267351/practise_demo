package LeetCode.month08.day09.demo3;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/8/9 10:23
 */
public class demo {
    private int res = 0;

    public int maxAncestorDiff(TreeNode root) {
        DFS(root, root.val, root.val);
        return res;
    }

    public void DFS(TreeNode root, int max, int min) {
        if (root == null) {
            res = Math.max(res, max - min);
            return;
        }
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        DFS(root.left, max, min);
        DFS(root.right, max, min);
    }
}

