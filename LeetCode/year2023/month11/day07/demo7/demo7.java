package month11.day07.demo7;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/7 12:59
 */
public class demo7 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int left, int right) {
        if (left > right) return null;
        int maxIndex = left;
        int max = nums[left];
        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = build(nums, left, maxIndex - 1);
        root.right = build(nums, maxIndex + 1, right);
        return root;
    }
}

