package month12.day22.demo4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/22 14:25
 */
public class demo4 {
    List<List<Integer>> res;

    public List<List<Integer>> BSTSequences(TreeNode root) {
        res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        if (root == null) {
            res.add(new ArrayList<>(path));
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
        for (int i = 0; i < size; i++) {
            TreeNode poll = queue.get(i);
            queue.remove(i);
            path.add(poll.val);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
            backtracking(queue, path);
            path.removeLast();
            queue.add(i,poll);
            if (poll.left != null) queue.removeLast();
            if (poll.right != null) queue.removeLast();
        }
    }
}

