package month07.day19.demo4;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/?envType=study-plan-v2&envId=coding-interviews
 * @date 2023/7/19 15:44
 */
public class demo4 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode parent = root;

        while (p.val < parent.val && q.val < parent.val || p.val > parent.val && q.val > parent.val) {
            if (p.val < parent.val) {
                parent = parent.left;
            }else {
                parent = parent.right;
            }
        }
        return parent;
    }
}

