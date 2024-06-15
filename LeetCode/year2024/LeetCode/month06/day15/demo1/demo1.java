package LeetCode.month06.day15.demo1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/15 14:13
 */
public class demo1 {
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
        TreeNode root = new TreeNode(rootValue);
        int rootIndex = map.get(rootValue);
        root.left = build(preorder, preLeft + 1, rootIndex - inLeft + preLeft, map, inLeft, rootIndex - 1);
        root.right = build(preorder, rootIndex - inLeft + preLeft + 1, preRight, map, rootIndex + 1, inRight);
        return root;
    }
}

