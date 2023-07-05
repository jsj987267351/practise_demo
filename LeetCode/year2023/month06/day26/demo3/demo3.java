package month06.day26.demo3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/6/26 14:18
 */
public class demo3 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }

        backtracking(root, targetSum);
        return res;
    }

    public void backtracking(TreeNode root, int targetSum) {
        path.add(root.val);

//        如果已经遍历到了叶子节点，就判断是否满足要求
        if (root.left == null && root.right == null) {
            if (targetSum - root.val == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

//        递归左右节点
        if (root.left != null) {
            backtracking(root.left, targetSum - root.val);
//            回溯
            path.removeLast();
        }

        if (root.right != null) {
            backtracking(root.right, targetSum - root.val);
            path.removeLast();
        }

    }
}

