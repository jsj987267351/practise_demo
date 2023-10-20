package month10.day20.demo5;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/?envType=list&envId=RxT23Yqb
 * @date 2023/10/20 15:49
 */
public class demo5 {
    int num, res;

    public int findTargetNode(TreeNode root, int cnt) {
        num = cnt;
        help(root);
        return res;
    }

    public void help(TreeNode root) {
        if (root == null) return;
        help(root.right);
        if (num == 0) return;
        num--;
        res = root.val;
        help(root.left);
    }
}

