package LeetCode.month06.day24.demo1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/24 9:49
 */
public class demo {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return res;
        backtracking(root, targetSum);
        return res;
    }

    public void backtracking(TreeNode root, int targetSum) {
        path.add(root.val);
        if (root.left == null && root.right == null && targetSum == root.val) {
            res.add(new ArrayList<>(path));
        }
        if (root.left != null) {
            backtracking(root.left, targetSum - root.val);
        }
        if (root.right != null) {
            backtracking(root.right, targetSum - root.val);
        }
        path.removeLast();
    }
}

