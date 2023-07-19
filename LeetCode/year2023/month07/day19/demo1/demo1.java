package month07.day19.demo1;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 * @date 2023/7/19 15:14
 */
public class demo1 {
    Node first;
    Node pre;

    public Node treeToDoublyList(Node root) {
//        中序遍历
        if (root == null) {
            return null;
        }
        help(root);
        pre.right = first;
        first.left = pre;
        return first;
    }

    public void help(Node root) {
        if (root == null) {
            return;
        }
        help(root.left);
        if (first == null) {
            first = root;
            pre = first;
        } else {
            pre.right = root;
            root.left = pre;
            pre = root;
        }
        help(root.right);
    }
}

