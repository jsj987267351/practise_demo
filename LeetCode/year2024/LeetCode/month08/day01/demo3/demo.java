package LeetCode.month08.day01.demo3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/8/1 9:35
 */
public class demo {
    class FindElements {
        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();

        public FindElements(TreeNode root) {
            root.val = 0;
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                set.add(poll.val);
                if (poll.left != null) {
                    poll.left.val = 2 * poll.val + 1;
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    poll.right.val = 2 * poll.val + 2;
                    queue.add(poll.right);
                }
            }
        }

        public boolean find(int target) {
            return set.contains(target);
        }
    }
}

