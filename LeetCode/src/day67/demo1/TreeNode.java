package day67.demo1;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/6/20 13:53
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

