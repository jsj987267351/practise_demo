package day2023_05_22.demo3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/5/22 17:36
 */
public class demo3 {
    public void flatten1(TreeNode root) {
        if (root==null){
            return;
        }
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        root.left = null;
        list.remove(0);
        for (Integer num : list) {
            root.right = new TreeNode(num);
            root = root.right;
            root.left = null;
        }
    }

    public void preOrder(TreeNode root, List<Integer> list) {

        if (root != null) {
            list.add(root.val);
            preOrder(root.left, list);
            preOrder(root.right, list);
        }
    }

//    不断将左子树接在root的右子树上，然后将原先的右子树接在原先左子树的最右节点上，循环往复
    public void flatten(TreeNode root) {
        while (root!=null){
            if (root.left==null){
//                右移一位
                root =root.right;
            }else {
//                找到左子树的最右节点
                TreeNode left = root.left;
                while (left.right!=null){
                    left = left.right;
                }
//                接上
                left.right = root.right;
                root.right = root.left;
//                左子树置空
                root.left = null;
//                继续向右
                root = root.right;
            }
        }
    }
}

