package month06.day21.demo2;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/delete-node-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/6/21 12:55
 */
public class demo2 {
//    递归含义，删除key值后剩下的节点
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
//        找到删除的节点为root
//        情况1；如果被删除的节点只有右孩子
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null){
//            情况2：被删除的节点只有左孩子
            return root.left;
        }
//        情况3，左右孩子都没有，包含在了情况1和2中，因为两个条件都能进入
//        情况4，左右孩子都有
//        找到需要顶替的后继节点
        TreeNode s = root.right;
        while (s.left!=null){
            s = s.left;
        }
//        先删，防止先添加孩子节点会导致删除多节点
        s.right = deleteNode(root.right,s.val);
        s.left = root.left;
        return s;
    }

}

