package day37.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 * @date 2023/5/8 16:47
 */
public class demo1 {
    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        bianli(root, list, k);

        return list.get(k - 1);
    }

    public void bianli(TreeNode root, List<Integer> list, int k) {

        if (root != null && k>0) {
            bianli(root.right, list, k);
            list.add(root.val);
            k--;
            bianli(root.left, list, k);
        }
    }
}

