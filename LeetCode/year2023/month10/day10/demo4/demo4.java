package month10.day10.demo4;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/?envType=list&envId=RxT23Yqb
 * @date 2023/10/10 13:49
 */
public class demo4 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = root;
        while (p.val < res.val && q.val < res.val || p.val > res.val && q.val > res.val) {
            if (p.val < res.val) {
                res = res.left;
            } else {
                res = res.right;
            }
        }
        return res;
    }
}

