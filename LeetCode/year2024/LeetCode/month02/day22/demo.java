package LeetCode.month02.day22;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/2/22 10:14
 */
public class demo {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }
        return help(preorder, 0, preorder.length - 1, map, 0, postorder.length - 1);
    }

    public TreeNode help(int[] preorder, int preLeft, int preRight, Map<Integer, Integer> map, int posLeft, int posRight) {
        if (preLeft > preRight || posLeft > posRight) return null;
        if (preLeft == preRight) return new TreeNode(preorder[preLeft]);
        int rootValue = preorder[preLeft];
        int leftRootIndex = map.get(preorder[preLeft + 1]);
        int leftSize = leftRootIndex - posLeft;
        TreeNode root = new TreeNode(rootValue);
        root.left = help(preorder, preLeft + 1, leftSize + preLeft + 1, map, posLeft, leftRootIndex);
        root.right = help(preorder, leftSize + preLeft + 2, preRight, map, leftRootIndex + 1, posRight - 1);
        return root;
    }
}

