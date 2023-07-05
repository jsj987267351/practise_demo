package month04.day26.demo1;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你二叉树的根节点root 和一个表示目标和的整数targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/path-sum
 * @date 2023/4/26 15:59
 */
public class demo1 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root ==null){
            return false;
        }
        if (root.left==null && root.right==null){
            return root.val ==targetSum;
        }
        return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);
    }
}

