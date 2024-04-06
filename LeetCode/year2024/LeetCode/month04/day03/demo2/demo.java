package LeetCode.month04.day03.demo2;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/4/3 11:44
 */
public class demo {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || original == target) return cloned;
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        if (left != null) {
            return left;
        }
        return getTargetCopy(original.right, cloned.right, target);
    }
}

