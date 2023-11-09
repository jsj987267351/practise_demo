package month11.day09.demo6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/9 13:21
 */
public class demo6_2 {
    LinkedList<Integer> list;
    List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        list = new LinkedList<>();
        backtracking(root, targetSum);
        return res;
    }

    private void backtracking(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null && root.val == targetSum) {
            res.add(new ArrayList<>(list));
//            这里不用return，因为遍历到叶子节点再往其孩子节点递归遍历会遇到空节点返回的
        }
        backtracking(root.left, targetSum - root.val);
        backtracking(root.right, targetSum - root.val);
        list.removeLast();
    }
}

