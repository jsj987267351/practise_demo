package LeetCode.month02.day21;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/2/21 10:53
 */
public class demo {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return help(postorder, 0, postorder.length - 1, map, 0, inorder.length - 1);
    }

    public TreeNode help(int[] postorder, int posLeft, int posRight, Map<Integer, Integer> map, int inLeft, int inRight) {
        if (posLeft > posRight || inLeft > inRight) return null;
        int rootValue = postorder[posRight];
        int rootIndex = map.get(rootValue);
        TreeNode root = new TreeNode(rootValue);
        root.left = help(postorder, posLeft, rootIndex - inLeft + posLeft - 1, map, inLeft, rootIndex - 1);
        root.right = help(postorder, rootIndex - inLeft + posLeft, posRight - 1, map, rootIndex + 1, inRight);
        return root;
    }
}

