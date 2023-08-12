package month08.day11.demo3;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * <p>
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * <p>
 * 叶节点 是指没有子节点的节点。
 * https://leetcode.cn/problems/sum-root-to-leaf-numbers/?envType=study-plan-v2&envId=top-interview-150
 * @date 2023/8/11 17:52
 */
public class demo3 {
    public int sumNumbers(TreeNode root) {
        return help(root, 0);
    }

    private int help(TreeNode root, int PreValue) {
//      这里处理单侧为空指针的节点，因为当前节点走到了空节点，但是该节点并不是叶子结点，并且题目要求只求到达叶子节点的和，所以记当前节点的和为0
        if (root == null) return 0;
//        PreValue为到达当前节点的父节点的值
//        temp为处理后到达当前节点的值
        int temp = PreValue * 10 + root.val;
//        如果到达叶子节点了就可以返回到达当前叶子节点的值了，因为前面已经相加处理过了
        if (root.left == null && root.right == null) {
            return temp;
        }
//        最终结果就是当前节点的左子树和右子树到达叶子节点的总值
        return help(root.left, temp) + help(root.right, temp);
    }
}

