package LeetCode.month08.day22.demo5;

import sun.dc.pr.PRError;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/8/22 10:52
 */
public class demo {
    List<Integer> list = new ArrayList<>();
    TreeNode pre = null;
    int max = Integer.MIN_VALUE;
    int count = 0;

    public int[] findMode(TreeNode root) {
        preOrder(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void preOrder(TreeNode root) {
        if (root == null) return;
        preOrder(root.left);
        if (pre == null || root.val != pre.val) {
            count = 1;
        } else if (root.val == pre.val) {
            count++;
        }
        if (count > max) {
            list.clear();
            max = count;
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }
        pre = root;
        preOrder(root.right);
    }
}

