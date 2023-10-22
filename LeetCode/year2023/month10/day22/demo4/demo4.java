package month10.day22.demo4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/22 12:28
 */
public class demo4 {
    List<String> res;
    LinkedList<Integer> list;

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return res;
        }
        res = new ArrayList<>();
        list = new LinkedList<>();
        backtracking(root, list);
        return res;
    }

    public void backtracking(TreeNode root, LinkedList<Integer> list) {
        list.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size() - 1; i++) {
                sb.append(list.get(i)).append("->");
            }
            sb.append(list.get(list.size() - 1));
            res.add(sb.toString());
            return;
        }

        if (root.left != null) {
            backtracking(root.left, list);
            list.removeLast();
        }
        if (root.right != null) {
            backtracking(root.right, list);
            list.removeLast();
        }
    }
}

