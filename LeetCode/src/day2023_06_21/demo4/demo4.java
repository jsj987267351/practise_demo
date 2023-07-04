package day2023_06_21.demo4;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/6/21 14:29
 */
public class demo4 {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root!=null){
            convertBST(root.right);
            root.val+=sum;
            sum = root.val;
            convertBST(root.left);
            return root;
        }
        return null;
    }
}

