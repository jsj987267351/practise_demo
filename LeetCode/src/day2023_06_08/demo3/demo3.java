package day2023_06_08.demo3;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/6/8 16:12
 */
public class demo3 {
    int max = Integer.MIN_VALUE;
//      自底向上求出每个节点的子树的最大值，最大值等于当前节点加上左子树或者右子树的最大值，因为要是一条长路径，所以左右子树只能选择一条，所以只能选其中的最大值
    public int maxPathSum(TreeNode root) {
        help(root);
        return max;
    }

    public int help(TreeNode root) {
//        空节点值为0
        if (root == null) {
            return 0;
        }
//      因为是求最大值，所以大于0才有求和的必要
        int left = Math.max(help(root.left), 0);
        int right = Math.max(help(root.right), 0);

//        当前节点的路径最大和
        int currentSum = root.val + left + right;
//        更新最大值
        max = Math.max(max, currentSum);

        return root.val + Math.max(left, right);
    }
}

