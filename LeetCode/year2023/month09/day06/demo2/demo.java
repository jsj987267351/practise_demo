package month09.day06.demo2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/bst-sequences-lcci/description/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/9/6 12:20
 */
public class demo {
    List<List<Integer>> res;

    //    题目：每个节点在数组中必须在其子孙节点前面
//      解题思路看题解
    public List<List<Integer>> BSTSequences(TreeNode root) {
        res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
//        特判
        if (root == null) {
            res.add(path);
            return res;
        }
//        用队列来存放已经遍历到的节点
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        backtracking(queue, path);
        return res;
    }

    public void backtracking(LinkedList<TreeNode> queue, LinkedList<Integer> path) {
//        如果队列中为空，代表遍历结束
        if (queue.isEmpty()) {
            res.add(new ArrayList<>(path));
            return;
        }
//        存储当前队列，后续便于回溯
        LinkedList<TreeNode> copy = new LinkedList<>(queue);
//        从队列中取出当前遍历到的节点进行处理
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            TreeNode cur = queue.remove(i);
            path.add(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
//           回溯
            backtracking(queue, path);
            path.removeLast();
            queue = new LinkedList<>(copy);
        }
    }
}

