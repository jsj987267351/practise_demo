package LeetCode.month08.day06.demo2;


import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/8/6 9:36
 */
public class demo {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }
        return build(map, preorder, 0, preorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode build(Map<Integer, Integer> map, int[] preorder, int preLeft, int preRight, int postLeft, int postRight) {
        if (preLeft > preRight || postLeft > postRight) {
            return null;
        }
        if (preLeft == preRight) {
            return new TreeNode(preorder[preLeft]);
        }
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        int leftRootIndex = map.get(preorder[preLeft + 1]);
        int leftSize = leftRootIndex - postLeft + 1;
        root.left = build(map, preorder, preLeft + 1, preLeft + leftSize, postLeft, leftRootIndex);
        root.right = build(map, preorder, preLeft + leftSize + 1, preRight, leftRootIndex + 1, postRight);
        return root;
    }
}

