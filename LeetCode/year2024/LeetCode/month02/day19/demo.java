package LeetCode.month02.day19;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/2/19 9:38
 */
public class demo {
    List<Integer> res;

    public List<Integer> postorder(Node root) {
        res = new ArrayList<>();
        post(root);
        return res;
    }

    public void post(Node root) {
        if (root != null) {
            for (Node child : root.children) {
                post(child);
            }
            res.add(root.val);
        }
    }
}

