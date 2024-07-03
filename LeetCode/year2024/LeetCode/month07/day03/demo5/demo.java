package LeetCode.month07.day03.demo5;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/3 10:10
 */
public class demo {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "";
            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                if (poll != null) {
                    sb.append(poll.val).append(",");
                    queue.add(poll.left);
                    queue.add(poll.right);
                } else {
                    sb.append("null").append(",");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) return null;
            String[] strings = data.split(",");
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
            queue.add(root);
            int index = 1;
            while (!queue.isEmpty()){
                TreeNode poll = queue.poll();
                if (!strings[index].equals("null")){
                    TreeNode left = new TreeNode(Integer.parseInt(strings[index]));
                    poll.left = left;
                    queue.add(left);
                }
                index++;
                if (!strings[index].equals("null")){
                    TreeNode right = new TreeNode(Integer.parseInt(strings[index]));
                    poll.right = right;
                    queue.add(right);
                }
                index++;
            }
            return root;
        }
    }
}

