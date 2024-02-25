package LeetCode.month02.day20;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/2/20 17:08
 */
public class demo {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return help(preorder, 0, preorder.length - 1, map, 0, inorder.length - 1);
    }

    public TreeNode help(int[] preorder, int preLeft, int preRight, Map<Integer, Integer> map, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int rootValue = preorder[preLeft];
        int rootIndex = map.get(rootValue);
        TreeNode root = new TreeNode(rootValue);
        root.left = help(preorder, preLeft + 1, rootIndex - inLeft + preLeft, map, inLeft, rootIndex - 1);
        root.right = help(preorder, rootIndex - inLeft + preLeft + 1, preRight, map, rootIndex + 1, inRight);
        return root;
    }
}

