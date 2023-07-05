package month06.day19.demo1;

import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * <p>
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-depth-of-n-ary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/6/19 14:24
 */
public class demo1 {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int result = 0;

        List<Node> children = root.children;

        for (Node node : children) {
            result = Math.max(result, maxDepth(node));
        }
        return result+1;
    }
}

