package month06.day21.demo3;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。修剪树 不应该 改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在 唯一的答案 。
 * <p>
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/trim-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/6/21 13:55
 */
public class demo3 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
//        如果当前节点小于low，那么当前节点的左子树一定都小于low，所以递归右子树即可
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
//        如果当前节点大于high，那么当前节点的右子树一定都大于high，所以递归左子树即可
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
//        符合要求的节点递归调用其左右子树
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
