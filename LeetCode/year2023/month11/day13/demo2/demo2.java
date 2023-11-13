package month11.day13.demo2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/13 12:26
 */
public class demo2 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(postorder, 0, postorder.length - 1, map, 0, inorder.length - 1);
    }

    public TreeNode build(int[] postorder, int postLeft, int postRight, Map<Integer, Integer> map, int inLeft, int inRight) {
        if (postLeft > postRight || inLeft > inRight) {
            return null;
        }
        int rootValue = postorder[postRight];
        int rootIndex = map.get(rootValue);
        TreeNode root = new TreeNode(rootValue);
        root.left = build(postorder, postLeft, rootIndex - 1 - inLeft + postLeft, map, inLeft, rootIndex - 1);
        root.right = build(postorder, rootIndex - inLeft + postLeft, postRight - 1, map, rootIndex + 1, inRight);
        return root;
    }
}

