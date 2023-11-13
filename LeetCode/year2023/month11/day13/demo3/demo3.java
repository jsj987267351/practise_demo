package month11.day13.demo3;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/13 12:36
 */
public class demo3 {
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
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }
        TreeNode temp = root.right;
        while (temp.left != null) {
            temp = temp.left;
        }
        temp.right = deleteNode(root.right, temp.val);
        temp.left = root.left;
        return temp;
    }
}

