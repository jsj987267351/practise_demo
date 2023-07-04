package day2023_05_09.demo1;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/5/9 18:08
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

