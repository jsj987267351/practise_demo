package month11.day08.demo5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/8 13:29
 */
public class demo5 {
    int count;
    int max;
    List<Integer> res;
    TreeNode pre;
//    之所以不能遇到不同才判断是因为有可能最后全部相同，而少了一次判断，就像遍历数组一样，这里的count代表的是当前遍历到的数字出现的次数，而不是pre的
    public int[] findMode(TreeNode root) {
        max = Integer.MIN_VALUE;
        res = new ArrayList<>();
        pre = null;
        help(root);
        int size = res.size();
        int[] resInts = new int[size];
        for (int i = 0; i < size; i++) {
            resInts[i] = res.get(i);
        }
        return resInts;
    }

    public void help(TreeNode root) {
        if (root == null) return;
        help(root.left);
        if (pre == null || root.val != pre.val) {
            count = 1;
        } else {
            count++;
        }
        if (count > max) {
            res.clear();
            res.add(root.val);
            max = count;
        } else if (count == max) {
            res.add(root.val);
        }
        pre = root;
        help(root.right);
    }
}

