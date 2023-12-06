package month12.day06.demo1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/6 12:52
 */
public class demo1 {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            Queue<TreeNode> queue = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                if (poll != null) {
                    sb.append(poll.val).append(",");
                    queue.offer(poll.left);
                    queue.offer(poll.right);
                } else {
                    sb.append("null").append(",");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.length() == 0){
                return null;
            }
            String[] values = data.split(",");
            TreeNode root = new TreeNode(Integer.parseInt(values[0]));
            int index = 1;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                TreeNode poll = queue.poll();
                if (!values[index].equals("null")){
                    TreeNode left = new TreeNode(Integer.parseInt(values[index]));
                    poll.left = left;
                    queue.offer(left);
                }
                index++;
                if (!values[index].equals("null")){
                    TreeNode right = new TreeNode(Integer.parseInt(values[index]));
                    poll.right = right;
                    queue.offer(right);
                }
                index++;
            }
            return root;
        }
    }
}

