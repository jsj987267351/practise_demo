package month07.day18.demo3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/18 13:01
 */
public class demo3 {
    List<List<Integer>> res;
    LinkedList<Integer> list;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new ArrayList<>();
        list = new LinkedList<>();
        if (root == null) {
            return res;
        }

        backtracking(root, target);
        return res;
    }

    public void backtracking(TreeNode root, int target) {
        list.add(root.val);

        if (root.left == null && root.right == null) {
            if (root.val - target == 0) {
                res.add(new ArrayList<>(list));
                return;
            }
        }

        if (root.left != null) {
            backtracking(root.left, target - root.val);
            list.removeLast();
        }

        if (root.right != null) {
            backtracking(root.right, target - root.val);
            list.removeLast();
        }
    }
}

