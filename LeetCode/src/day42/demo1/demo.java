package day42.demo1;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 *
 * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/search-in-a-binary-search-tree
 * @date 2023/5/14 18:28
 */
public class demo {
    public TreeNode searchBST(TreeNode root, int val) {

        if (root ==null){
            return null;
        }

        if (root.val < val){
            return searchBST(root.right,val);
        }else if (root.val > val){
            return searchBST(root.left,val);
        }else {
            return root;
        }
    }
}

