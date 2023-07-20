package month07.day20.demo2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 请实现两个函数，分别用来序列化和反序列化二叉树。
 * <p>
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/xu-lie-hua-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/20 14:14
 */
public class demo2 {
    public class Codec {

        // Encodes a tree to a single string.
//        层序遍历将二叉树的所有元素存入一个字符串中，中间用，隔开
//        如果遇到null 同样存入null字符串
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                if (poll != null) {
                    sb.append(poll.val).append(',');
                    queue.offer(poll.left);
                    queue.offer(poll.right);
                } else {
                    sb.append("null").append(',');
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
//            特判
            if (data.length()==0) {
                return null;
            }
//            将字符串通过，分开成数组
            String[] values = data.split(",");
            TreeNode root = new TreeNode(Integer.parseInt(values[0]));
//            数组索引
            int index = 1;
//            层序遍历放入队列，队列中都是还未对左右子树赋值的
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                if (!values[index].equals("null")) {
                    TreeNode left = new TreeNode(Integer.parseInt(values[index]));
                    poll.left = left;
                    queue.offer(left);
                }
                index++;
                if (!values[index].equals("null")) {
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

