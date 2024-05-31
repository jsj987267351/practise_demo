package LeetCode.month05.day31.demo1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/5/31 11:11
 */
public class demo {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res  = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        if (root == null){
            return res;
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left!=null){
                    queue.add(poll.left);
                }
                if (poll.right!=null){
                    queue.add(poll.right);
                }
                if (i == size - 1){
                    res.add(poll.val);
                }
            }
        }
        return res;
    }
}

