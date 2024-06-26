package LeetCode.month06.day26.demo5;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/26 9:48
 */
public class demo {
    int res = 0;

    public int minCameraCover(TreeNode root) {
//        0未覆盖、1覆盖、2有摄像头
        if (backtracking(root) == 0) {
            res++;
        }
        return res;
    }

    public int backtracking(TreeNode root) {
        if (root == null) {
            return 1;
        }
        int left = backtracking(root.left);
        int right = backtracking(root.right);
        if (left == 0 || right == 0) {
            res++;
            return 2;
        }
        if (left == 1 && right == 1) {
            return 0;
        }
        if (left == 2 || right == 2) {
            return 1;
        }
        return -1;
    }
}

