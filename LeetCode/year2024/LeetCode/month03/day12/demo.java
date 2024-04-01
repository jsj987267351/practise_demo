package LeetCode.month03.day12;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/3/12 14:19
 */
public class demo {
    class FindElements {
        TreeNode root;
        Set<Integer> set;

        public FindElements(TreeNode a) {
            root = a;
            root.val = 0;
            set = new HashSet<>();
            set.add(0);
            help(root.left, root.right, 0);
        }

        public void help(TreeNode left, TreeNode right, int value) {
            if (left == null && right == null) {
                return;
            }
            if (left != null) {
                left.val = 2 * value + 1;
                set.add(left.val);
                help(left.left, left.right, left.val);
            }
            if (right != null) {
                right.val = 2 * value + 2;
                set.add(right.val);
                help(right.left, right.right, right.val);
            }
        }

        public boolean find(int target) {
            return set.contains(target);
        }
    }
}

