package day2023_06_20.demo1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 * <p>
 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 * 返回 nums 构建的 最大二叉树 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/6/20 13:53
 */
public class demo1 {
    public TreeNode constructMaximumBinaryTree1(int[] nums) {
//        与根据前中书序数组构建二叉树同理
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        return build(map, nums, 0, nums.length - 1);
    }

    private TreeNode build(Map<Integer, Integer> map, int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int max = find(nums, start, end);
        TreeNode root = new TreeNode(max);
        int index = map.get(max);
        root.left = build(map, nums, start, index - 1);
        root.right = build(map, nums, index + 1, end);
        return root;
    }

    private int find(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
//        同理但是不使用map集合存储索引，直接去查找索引
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) return null;
        int index = findIndex(nums, start, end);
        int value = nums[index];
        TreeNode root = new TreeNode(value);
        root.left = buildTree(nums, start, index - 1);
        root.right = buildTree(nums, index + 1, end);
        return root;
    }

    private int findIndex(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE, index = -1;
        for (int i = start; i <= end; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }

}

