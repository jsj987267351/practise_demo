package LeetCode.month06.day15.demo6;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/15 14:41
 */
public class demo6 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(map, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode build(Map<Integer, Integer> map, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }
        int rootValue = postorder[postRight];
        TreeNode root = new TreeNode(rootValue);
        int index = map.get(rootValue);
        root.left = build(map, inLeft, index - 1, postorder, postLeft, postRight - inRight + index - 1);
        root.right = build(map, index + 1, inRight, postorder, postRight - inRight + index, postRight - 1);
        return root;
    }
}

