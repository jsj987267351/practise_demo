package month11.day25;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/25 12:08
 */
public class demo {
    int res;

    public int pseudoPalindromicPaths(TreeNode root) {
//       因为二叉树中数值在1~9之间，所以用一个数字的二进制后10位来记录当前路径中每个数字出现的奇偶次数，初始全部为0
//        0代表出现次数偶次，1代表出现次数奇次。
        res = 0;
        backtracking(root, 0);
        return res;
    }

    public void backtracking(TreeNode root, int num) {
//        每出现一次，数值对应位置就与1异或，0变1，1变0，代表着奇变偶，偶变奇
        num ^= (1 << root.val);
        if (root.left == null && root.right == null) {
//            遇到叶子节点就判断奇次出现次数是否小于2，小于2就可以组成回文
            if (Integer.bitCount(num) < 2) {
                res++;
            }
            return;
        }
        if (root.left != null) {
            backtracking(root.left, num);
        }
        if (root.right != null) {
            backtracking(root.right, num);
        }
//        回溯
        num ^= (1 << root.val);
    }
}

