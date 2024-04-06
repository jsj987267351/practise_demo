package LeetCode.month04.day06.demo;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/4/6 14:48
 */
public class demo {
    int res;

    public int maxAncestorDiff(TreeNode root) {
//        题目求的是绝对值，所以就路径上的最大值和最小值即可
        dfs(root, root.val, root.val);
        return res;
    }

    //    到达root节点时的最大值和最小值
    public void dfs(TreeNode root, int max, int min) {
        if (root == null) {
//            遍历到空节点时说明当前路线中已经记录了最大值和最小值，更新结果即可
            res = Math.max(res, max - min);
            return;
        }
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        dfs(root.left, max, min);
        dfs(root.right, max, min);
    }
}

