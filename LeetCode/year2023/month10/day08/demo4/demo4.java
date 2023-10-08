package month10.day08.demo4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/?envType=list&envId=hliQiQFH
 * @date 2023/10/8 12:41
 */
public class demo4 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, map, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int preLeft, int preRight, Map<Integer, Integer> map, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int rootValue = preorder[preLeft];
        int rootIndex = map.get(rootValue);
        TreeNode root = new TreeNode(rootValue);
        root.left = build(preorder, preLeft + 1, rootIndex - inLeft + preLeft, map, inLeft, rootIndex - 1);
        root.right = build(preorder, rootIndex - inLeft + preLeft + 1, preRight, map, rootIndex + 1, inRight);
        return root;
    }
}

