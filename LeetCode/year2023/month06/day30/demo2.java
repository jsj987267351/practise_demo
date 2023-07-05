package month06.day30;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/6/30 13:56
 */
public class demo2 {
    public int numTrees(int n) {
//        dp[i]下标含义，连续数字数量为i时 有多少种互不相同的二叉搜索树   （例如45和12 数量都是二，虽然数字内容不同，但是能组成的不同二叉搜索树的数量是一样的）
        int[] dp = new int[n + 1];
//        空树也是二叉搜索树
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
//            头节点分别为 1到i 的所有情况之和
            for (int j = 1; j <= i; j++) {
//                该节点为头节点时其左子树的种类*右子树的种类 就等于该节点为头节点时一共有多少种不同的二叉搜索树
//                当前节点值为j，右子树为比其小的数值的数量，所以为j-1
//                当前节点值为j,右子树为比其大的数值的数量，所以为i-j(i为连续数量的总数)
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}

