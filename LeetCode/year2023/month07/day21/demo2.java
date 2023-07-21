package month07.day21;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/?envType=study-plan-v2&envId=coding-interviews
 * @date 2023/7/21 14:17
 */
public class demo2 {
    public boolean verifyPostorder(int[] postorder) {
//        特判
        if (postorder.length < 3) {
            return true;
        }
        return help(postorder, 0, postorder.length - 1);
    }

    //    判断当前树是否是二叉搜索树
    public boolean help(int[] postorder, int left, int right) {
//        如果left>=right代表搜索完了整个列表，直接返回true
        if (left >= right) {
            return true;
        }
//        从左往右找到第一个大于根节点的值，代表当前找过的节点就是左子树
        int p = left;
        while (postorder[p] < postorder[right]) {
            p++;
        }
//        判断右子树的节点值是否都大于根节点
//        接着继续往后遍历，找第一个小于等于根节点的值，因为是二叉搜索树，且任意数字都不同
//        所以应该从当前节点到根节点以前都是右子树，也就是说应该都大于根节点才对
        int m = p;
        while (postorder[p] > postorder[right]) {
            p++;
        }
//      如果当前节点能遍历到根节点，说明当前节点到根节点之间的值都是大于根节点的值的，继续判断左右子树区间
        return p == right && help(postorder, left, m - 1) && help(postorder, m, right - 1);
    }
}

