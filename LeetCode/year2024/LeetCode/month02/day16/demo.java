package LeetCode.month02.day16;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/2/16 10:14
 */
public class demo {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
                if (flag) {
                    list.addLast(poll.val);
                } else {
                    list.addFirst(poll.val);
                }
            }
            res.add(new ArrayList<>(list));
            flag = !flag;
        }
        return res;
    }
}

