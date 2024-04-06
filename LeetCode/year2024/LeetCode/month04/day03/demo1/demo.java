package LeetCode.month04.day03.demo1;


import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/4/3 11:22
 */
public class demo {
    //        看灵神解析
//    因为题目n<=20，也就意味着最多有10个叶子节点，因为n=1时有一个叶子节点，之后每加两个节点就多一个叶子节点
//    dp[i]表示有i个叶子节点时的真二叉树列表
    private static final List<TreeNode> dp[] = new List[11];

    static {
        for (int i = 0; i < 11; i++) {
            dp[i] = new ArrayList<>();
        }
//        只有一个叶子节点时就意味着只有根节点一种情况，特殊处理
        dp[1].add(new TreeNode(0));
//        处理其他叶子节点数量的情况
        for (int i = 2; i < 11; i++) {
//            左子树有几个叶子节点的情况，因为要保证是真二叉树，所以右子树最少要有一个叶子节点，这里不能用<=
            for (int left = 1; left < i; left++) {
//                遍历左子树的所有情况
                for (TreeNode leftNode : dp[left]) {
//                遍历右子树的所有情况
                    for (TreeNode rightNode : dp[i - left]) {
//                        进行组合
                        dp[i].add(new TreeNode(0, leftNode, rightNode));
                    }
                }
            }
        }
    }

    public List<TreeNode> allPossibleFBT(int n) {
//        如果总结点为偶数的话那么就无法组成真二叉树，返回dp[0]，dp[0]未添加节点，为空列表
//        否则的话计算总共有多少叶子节点的情况返回
        return dp[n % 2 == 0 ? 0 : (n + 1) / 2];
    }
}

