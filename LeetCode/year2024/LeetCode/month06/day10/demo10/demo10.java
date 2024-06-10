package LeetCode.month06.day10.demo10;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/10 17:31
 */
public class demo10 {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int res = 0;
        for (Node child : root.children) {
            res = Math.max(res, maxDepth(child));
        }
        return res + 1;
    }
}

