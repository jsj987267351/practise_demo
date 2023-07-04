package day2023_05_11.demo1;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/5/11 15:44
 */
public class demo1 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);

    }

    public TreeNode buildTree(int[] nums , int start ,int end){
        if (start > end){
            return null;
        }
        int mid = start + (end - start)/2;
//        int mid = (start + end) >>>1;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = buildTree(nums,start,mid-1);
        treeNode.right = buildTree(nums,mid+1,end);
        return treeNode;
    }
}

