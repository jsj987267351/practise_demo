package month11.day22.demo5;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/22 14:05
 */
public class demo5 {
    Node first;
    Node pre;

    public Node treeToDoublyList(Node root) {
        if (root == null){
            return null;
        }
        help(root);
        first.left = pre;
        pre.right = first;
        return first;
    }

    public void help(Node root) {
        if (root != null) {
            help(root.left);
            if (first == null) {
                first = root;
                pre = root;
            } else {
                pre.right = root;
                root.left = pre;
                pre = root;
            }
            help(root.right);
        }
    }
}

