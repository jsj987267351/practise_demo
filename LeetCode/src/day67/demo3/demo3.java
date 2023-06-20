package day67.demo3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 * <p>
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 * <p>
 * 假定 BST 满足如下定义：
 * <p>
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-mode-in-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/6/20 15:07
 */
public class demo3 {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();

    public int[] findMode1(TreeNode root) {
//        暴力解法，直接map记录每个数字出现的频率
        help(root);
        int sum = 0;
        for (int value : map.values()) {
            sum = Math.max(sum, value);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == sum) {
                list.add(key);
            }
        }
        int size = list.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void help(TreeNode root) {
        if (root != null) {
            map.put(root.val, map.getOrDefault(root.val, 0) + 1);
            help(root.left);
            help(root.right);
        }
    }

    //    直接中序遍历，因为二叉搜索树中序遍历为有序数组，相邻的一定在一起
    List<Integer> maxList;
    TreeNode pre;
    int count;
    int max;
    public int[] findMode(TreeNode root) {
        maxList = new ArrayList<>();
        count = 1;
        max = 0;
        find(root);
        int size = maxList.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = maxList.get(i);
        }
        return res;
    }

    private void find(TreeNode root) {
        if (root == null) return;
        find(root.left);
        if (pre==null || root.val!= pre.val){
            count = 1;
        }else {
            count++;
        }
        if (count >max){
            maxList.clear();
            maxList.add(root.val);
            max = count;
        }else if (count == max){
            maxList.add(root.val);
        }
        pre = root;
        find(root.right);
    }

}

