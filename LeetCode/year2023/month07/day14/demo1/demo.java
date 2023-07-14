package month07.day14.demo1;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个有 N 个结点的二叉树的根结点 root，树中的每个结点上都对应有 node.val 枚硬币，并且总共有 N 枚硬币。
 * <p>
 * 在一次移动中，我们可以选择两个相邻的结点，然后将一枚硬币从其中一个结点移动到另一个结点。(移动可以是从父结点到子结点，或者从子结点移动到父结点。)。
 * <p>
 * 返回使每个结点上只有一枚硬币所需的移动次数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/distribute-coins-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/14 16:29
 */
public class demo {
    int res = 0;

    public int distributeCoins(TreeNode root) {
//        如果根节点不需要向上继续汇报需要移动多少硬币，说明正好可以分配。否则说明金币不足或超出
        return help(root) == 0 ? res : -1;
    }

//    返回每个节点需要向上移动的硬币的个数，即当前连接当前节点的路径需要经过多少次
    private int help(TreeNode root) {
//        空节点不需要向上汇报需要多少硬币
        if (root == null) {
            return 0;
        }
//        左子树向上汇报需要移动多少硬币
        int left = help(root.left);
//        加上绝对值是因为，有可能左子树硬币不足1，那么汇报过来的需要移动的就是负数，也就是需要向下移动，所以同样是移动，步数是一样的
        res += Math.abs(left);
//        右子树向上汇报需要移动多少硬币
        int right = help(root.right);
        res += Math.abs(right);
//        当前节点向上汇报需要移动多少硬币就是左子树移动过来的硬币+右子树移动过来的硬币+本身有的硬币后，自身只留一个硬币，其他全部继续向上汇报需要移动的硬币
        return left + right + root.val - 1;
    }
}

