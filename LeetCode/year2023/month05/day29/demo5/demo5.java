package month05.day29.demo5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/5/29 17:35
 */
public class demo5 {
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        int rootNum = preorder[0];
        TreeNode root = new TreeNode(rootNum);

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootNum) {
//                左闭右开
                int[] inLeft = Arrays.copyOfRange(inorder, 0, i);
                int[] inRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);

                int[] preLeft = Arrays.copyOfRange(preorder, 1, i + 1);
                int[] preRight = Arrays.copyOfRange(preorder, i + 1, preorder.length);

                root.left = buildTree1(preLeft, inLeft);
                root.right = buildTree1(preRight, inRight);
                break;
            }
        }
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
//      存在中序遍历值对应的索引下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return myBuildTree(preorder, 0, preorder.length - 1, map, 0, inorder.length - 1);
    }

    private TreeNode myBuildTree(int[] preorder, int preLeft, int preRight, Map<Integer, Integer> map, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int rootValue = preorder[preLeft];
        TreeNode root = new TreeNode(rootValue);
//        找到根节点在中序遍历的索引
        Integer index = map.get(rootValue);
        root.left = myBuildTree(preorder, preLeft + 1, index - inLeft + preLeft, map, inLeft, index - 1);
        root.right = myBuildTree(preorder, index - inLeft + preLeft + 1, preRight, map, index + 1, inRight);
        return root;
    }


}

