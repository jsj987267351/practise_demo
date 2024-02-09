package LeetCode.month02.day08;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/2/8 12:04
 */
public class demo {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null || root.val == x || root.val == y) return false;
        TreeNode xNode = null, yNode = null, xParent = null, yParent = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.add(poll.left);
                    if (poll.left.val == x) {
                        xNode = poll.left;
                        xParent = poll;
                    }
                    if (poll.left.val == y) {
                        yNode = poll.left;
                        yParent = poll;
                    }
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                    if (poll.right.val == x) {
                        xNode = poll.right;
                        xParent = poll;
                    }
                    if (poll.right.val == y) {
                        yNode = poll.right;
                        yParent = poll;
                    }
                }
            }
            if (xNode != null && yNode != null) {
                return xParent != yParent;
            } else if (xNode != null || yNode != null) {
                return false;
            }
        }
        return true;
    }
}

