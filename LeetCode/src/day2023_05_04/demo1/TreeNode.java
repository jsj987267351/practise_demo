package day2023_05_04.demo1;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/5/4 14:59
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

