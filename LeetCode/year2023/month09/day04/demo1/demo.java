package month09.day04.demo1;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 * <p>
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 * https://leetcode.cn/problems/successor-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/9/4 12:34
 */
public class demo {
    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        TreeNode res = null;
//        如果p的右子树不为空的话，根据二叉搜索树性质，右子树的最小值就是后继节点
        if (p.right != null) {
            res = p.right;
            while (res.left != null) {
                res = res.left;
            }
            return res;
        }
//        右子树为空的话，后继节点就是其父节点，从头遍历找父节点
        TreeNode node = root;
        while (node != null) {
            if (node.val > p.val) {
//                如果当前节点的值大于目标值，则其后继节点在其左节点，并且包括当前值
                res = node;
                node = node.left;
            } else {
//                否则就在其右节点，但不包括当前值
                node = node.right;
            }
        }
        return res;
    }


    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        if (p.val >= root.val) {
//           如果当前节点的值小于等于目标值，则其后继节点在其右节点，并且不包括当前值
            return inorderSuccessor(root.right, p);
        }
//           如果当前节点的值大于目标值，则其后继节点在其左节点，并且包括当前值,左子树没找到说明当前节点就是后继节点，因为是包括在内的
        TreeNode left = inorderSuccessor(root.left, p);
        return left == null ? root : left;
    }
}

