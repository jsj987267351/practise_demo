package day2023_06_08.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/?envType=study-plan-v2&envId=top-100-liked
 * @date 2023/6/8 14:53
 */
public class demo1 {
    public int kthSmallest(TreeNode root, int k) {
//        定义集合用来存储元素，里面将前k小个都存储下来
        List<Integer> list = new ArrayList<>();
        help(root, k, list);
//        最后返回最后一个元素即可
        return list.get(k - 1);
    }

    public void help(TreeNode root, int k, List<Integer> list) {
        if (root != null) {
//            因为是二叉搜索树，所以左中右就是递增
            help(root.left, k, list);
            if (list.size() <= k) list.add(root.val);
            help(root.right, k, list);
        }
    }
}
//直接利用二叉搜索树的左<中<右进行中序遍历，遍历k个数字，返回最后一个即可

