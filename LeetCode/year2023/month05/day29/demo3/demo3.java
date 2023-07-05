package month05.day29.demo3;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/5/29 16:07
 */
public class demo3 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//      后序遍历，遇到空节点，即叶子节点的孩子节点，直接返回null，因为肯定不是p或q，否则如果遇到p或q，就直接返回当前节点
        if (root == null || root == p || root == q) {
            return root;
        }
//        左
        TreeNode left = lowestCommonAncestor(root.left, p, q);
//        右
        TreeNode right = lowestCommonAncestor(root.right, p, q);
//        如果包含p或q，则会返回该节点，否则返回的就会是null
        if (left != null && right != null) {
//            说明左节点和右节点都不为null，说明左右节点都包含了p或q，又因为p和q唯一，所以一定是一左一右
            return root;
        } else if (left == null && right != null) {
//            右节点不为空，说明右节点遇到了p或q，将右节点返回
            return right;
        } else if (right == null && left != null) {
//            左节点不为空，说明左节点遇到了p或q，将左节点返回
            return left;
        } else
//            到达叶子节点，叶子节点左右一定不包含，所以直接返回null
            return null;
    }
}

