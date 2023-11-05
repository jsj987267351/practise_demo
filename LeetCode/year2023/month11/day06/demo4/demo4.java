package month11.day06.demo4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/5 16:53
 */
public class demo4 {
    public TreeNode deduceTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helpBuild(preorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
    }

    public TreeNode helpBuild(int[] preorder, int preLeft, int preRight, int inLeft, int inRight, Map<Integer, Integer> map) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int rootValue = preorder[preLeft];
        TreeNode root = new TreeNode(rootValue);
        int index = map.get(rootValue);
        root.left = helpBuild(preorder, preLeft + 1, index - inLeft + preLeft, inLeft, index - 1, map);
        root.right = helpBuild(preorder, index - inLeft + preLeft + 1, preRight, index + 1, inRight, map);
        return root;
    }
}

