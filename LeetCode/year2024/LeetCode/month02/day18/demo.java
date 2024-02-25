package LeetCode.month02.day18;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/2/18 9:41
 */
public class demo {
    List<Integer> res;

    public List<Integer> preorder(Node root) {
        res = new ArrayList<>();
        pre(root);
        return res;
    }

    public void pre(Node root) {
        if (root != null) {
            res.add(root.val);
            for (Node child : root.children) {
                pre(child);
            }
        }
    }
}

