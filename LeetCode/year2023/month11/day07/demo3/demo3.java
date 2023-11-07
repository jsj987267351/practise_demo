package month11.day07.demo3;

import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/7 12:23
 */
public class demo3 {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        List<Node> children = root.children;
        int max = 1;
        for (Node child : children) {
            max = Math.max(max, maxDepth(child));
        }
        return max + 1;
    }
}

