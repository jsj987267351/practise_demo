package month07.day17.demo3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/?envType=study-plan-v2&envId=coding-interviews
 * @date 2023/7/17 18:13
 */
public class demo3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
//        双端队列
        boolean flag = false;
        List<List<Integer>> res = new ArrayList<>();
        if (root ==null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (flag) {
//                    偶数层从右到左
                    list.addFirst(poll.val);
                } else {
//                    奇数层从左到右
                    list.addLast(poll.val);
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            flag = !flag;
            res.add(new ArrayList<>(list));
        }
        return res;
    }
}

