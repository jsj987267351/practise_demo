package month10.day30.demo5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/30 12:50
 */
public class demo5 {
    List<Integer> res;

    public List<Integer> preorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        help(root);
        return res;
    }

    public void help(TreeNode root) {
        if (root != null) {
            res.add(root.val);
            help(root.left);
            help(root.right);
        }
    }
}

