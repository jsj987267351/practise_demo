package month06.day02.demo3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * <p>
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof/
 * @date 2023/6/2 20:03
 */
public class demo3 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return help(preorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
    }

    public TreeNode help(int[] preorder, int preLeft, int preRight, int inLeft, int inRight, Map<Integer, Integer> map) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int rootValue = preorder[preLeft];
        TreeNode root = new TreeNode(rootValue);
        Integer index = map.get(rootValue);
        root.left = help(preorder, preLeft + 1, index - inLeft + preLeft, inLeft, index - 1, map);
        root.right = help(preorder, index - inLeft + preLeft + 1, preRight, index + 1, inRight, map);
        return root;
    }
}

