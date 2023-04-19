package day28.demo1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/4/19 14:34
 */
public class demo1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 1;
        while (!queue.isEmpty()){
            int temp = 0;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < sum; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left!=null){
                    queue.offer(poll.left);
                    temp++;
                }
                if (poll.right!=null){
                    queue.offer(poll.right);
                    temp++;
                }
            }
            result.add(list);
            sum = temp;
        }

        return result;
    }
}

