package month09.day03.demo1;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/9/3 12:13
 */
public class demo {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length);
    }

    public TreeNode build(int[] nums, int left, int right) {
        if (left == right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, left, mid);
        root.right = build(nums, mid + 1, right);
        return root;
    }
}

