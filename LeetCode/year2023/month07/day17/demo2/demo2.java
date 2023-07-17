package month07.day17.demo2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 * @date 2023/7/17 18:07
 */
public class demo2 {
    public int[] levelOrder(TreeNode root) {
        if (root ==null){
            return new int[0];
        }
//        层序遍历
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                list.add(poll.val);
            }
        }
        int[] res = new int[list.size()];
        int index = 0;
        for (int integer : list) {
            res[index++] = integer;
        }

        return res;
    }
}

