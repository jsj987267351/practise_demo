package LeetCode.month07.day18;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/18 13:47
 */
public class demo {
    List<List<Integer>> res;

    public List<List<Integer>> BSTSequences(TreeNode root) {
        res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        if (root == null) {
            res.add(path);
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        backtracking(queue, path);
        return res;
    }

    public void backtracking(LinkedList<TreeNode> queue, LinkedList<Integer> path) {
        if (queue.isEmpty()) {
            res.add(new ArrayList<>(path));
            return;
        }
        int size = queue.size();
        ArrayDeque<TreeNode> copy = new ArrayDeque<>(queue);
        for (int i = 0; i < size; i++) {
            TreeNode poll = queue.remove(i);
            path.add(poll.val);
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
            backtracking(queue, path);
            path.removeLast();
            queue = new LinkedList<>(copy);
        }
    }
}

