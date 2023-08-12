package month08.day12.demo2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/binary-search-tree-iterator/description/?envType=study-plan-v2&envId=top-interview-150
 * @date 2023/8/12 18:19
 */
public class demo2 {
    class BSTIterator {
        int index;
        List<Integer> list;
        TreeNode myRoot;

        public BSTIterator(TreeNode root) {
            myRoot = root;
            index = 0;
            list = new ArrayList<>();
            middle(myRoot);
        }

        public int next() {
            return list.get(index++);
        }

        public boolean hasNext() {
            if (index < list.size()) {
                return true;
            }
            return false;
        }

        public void middle(TreeNode root) {
            if (root != null) {
                middle(root.left);
                list.add(root.val);
                middle(root.right);
            }
        }
    }
}

