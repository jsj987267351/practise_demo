package month11.day09.demo6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/9 13:11
 */
public class demo6 {
    LinkedList<Integer> list;
    List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        list = new LinkedList<>();
        if (root == null) {
            return res;
        }
        backtracking(root, targetSum);
        return res;
    }

    public void backtracking(TreeNode root, int targetSum) {
        list.add(root.val);

        if (root.left == null && root.right == null && targetSum == root.val) {
            res.add(new ArrayList<>(list));
            return;
        }

        if (root.left != null) {
            backtracking(root.left, targetSum - root.val);
            list.removeLast();
        }

        if (root.right != null) {
            backtracking(root.right, targetSum - root.val);
            list.removeLast();
        }
    }
}

