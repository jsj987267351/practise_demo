package LeetCode.month06.day12.demo4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/12 13:33
 */
public class demo {
    List<Integer> list = new ArrayList<>();
    TreeNode pre;
    int max = Integer.MIN_VALUE;
    int count = 0;

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (pre == null || root.val != pre.val) {
            count = 1;
        } else {
            count++;
        }
        if (count > max) {
            list.clear();
            list.add(root.val);
            max = count;
        } else if (count == max) {
            list.add(root.val);
        }
        pre = root;
        dfs(root.right);
    }
}

