package month08.day12.demo4;


import java.util.*;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/description/?envType=study-plan-v2&envId=top-interview-150
 * @date 2023/8/12 18:30
 */
public class demo4 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
//        使用双端列表，奇数层尾插，偶数层头插法收集即可
        queue.offerLast(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (flag) {
                    list.offerLast(poll.val);
                } else {
                    list.offerFirst(poll.val);
                }
                if (poll.left != null) {
                    queue.offerLast(poll.left);
                }
                if (poll.right != null) {
                    queue.offerLast(poll.right);
                }
            }
            res.add(new ArrayList<>(list));
            flag = !flag;
        }
        return res;
    }
}

