package day2023_07_04.demo1;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 * <p>
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * <p>
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/house-robber-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/4 12:29
 */
public class demo1 {
    public int rob(TreeNode root) {
//        动态规划：dp数组 dp[0]表示不偷当前节点的最大值  dp[1]表示偷当前节点的最大值
//        这里就利用后序遍历返回了偷与不偷根节点的数组
        int[] dp = help(root);
        return Math.max(dp[0], dp[1]);
    }


    public int[] help(TreeNode root) {
//        递归中止条件：遇到空节点的话偷与不偷的最大值都是0
        if (root == null) {
            return new int[]{0, 0};
        }

//        利用后序遍历，因为每个节点偷与不偷需要根据其左右子树决定
        int[] leftDp = help(root.left);
        int[] rightDp = help(root.right);

//        计算当前节点偷与不偷的最大值
//       当前节点偷的话，那么其子节点就不能偷，所以就要取其不偷的最大值加上当前节点的值
        int steal = root.val + leftDp[0] + rightDp[0];

//        当前节点不偷的话，就要去左右孩子节点偷与不偷的最大值的总和
        int NoSteal = Math.max(leftDp[0], leftDp[1]) + Math.max(rightDp[0], rightDp[1]);

//        最后返回当前节点偷与不偷的最大值
        return new int[]{NoSteal, steal};
    }
}

