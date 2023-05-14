package day42.demo3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树
 * https://leetcode.cn/problems/validate-binary-search-tree/
 * @date 2023/5/14 19:03
 */
public class demo {
    public boolean isValidBST1(TreeNode root) {
//        使用中序遍历，如果遍历出来的数组是有序的，则为二叉搜索树
        List<Integer> list = new ArrayList<>();
        midOrder(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public void midOrder(TreeNode root, List<Integer> list) {

        if (root != null) {
            midOrder(root.left, list);
            list.add(root.val);
            midOrder(root.right, list);
        }
    }


    long pre = Long.MIN_VALUE;

    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST2(root.left);
        if (!left) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        boolean right = isValidBST2(root.right);
        return right;
    }


    public boolean isValidBST(TreeNode root) {
        return helper3(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean helper3(TreeNode root, long left, long right){
        if (root==null){
            return true;
        }
        if (root.val<=left || root.val>=right){
            return false;
        }
        return helper3(root.left,left,root.val) && helper3(root.right,root.val,right);
    }
}

