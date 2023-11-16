package month11.day16.demo6;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/16 12:47
 */
public class demo6 {
    int res = 0;

    public int minCameraCover(TreeNode root) {
//        0:无覆盖 1：摄像头 2：覆盖
        if (help(root) == 0) {
            res++;
        }
        return res;
    }

    public int help(TreeNode root) {
        if (root == null) {
            return 2;
        }
        int left = help(root.left);
        int right = help(root.right);
        if (left == 2 && right == 2) {
            return 0;
        }
        if (left == 0 || right == 0) {
            res++;
            return 1;
        }
        if (left == 1 || right == 1) {
            return 2;
        }
        return 999;
    }
}

