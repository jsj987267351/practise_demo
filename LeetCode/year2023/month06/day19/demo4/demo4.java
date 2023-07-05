package month06.day19.demo4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/6/19 16:08
 */
public class demo4 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return myBuildTree(postorder, 0, postorder.length - 1, map, 0, inorder.length - 1);
    }

    private TreeNode myBuildTree(int[] postorder, int posLeft, int posRight, Map<Integer, Integer> map, int inLeft, int inRight) {
        if (posLeft > posRight || inLeft > inRight) {
            return null;
        }

        int value = postorder[posRight];
        TreeNode root = new TreeNode(value);
        int index = map.get(value);
        root.left = myBuildTree(postorder, posLeft, posLeft + index - inLeft-1, map, inLeft, index-1);
        root.right = myBuildTree(postorder, posLeft + index - inLeft , posRight - 1, map, index + 1, inRight);
        return root;
    }
}

