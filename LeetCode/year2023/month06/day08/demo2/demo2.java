package month06.day08.demo2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/6/8 15:08
 */
public class demo2 {
    //    利用前缀和,key定义为long，是因为有个别题用Integer会损失精度
     static Map<Long, Integer> map;
    static int target;

    public static int pathSum(TreeNode root, int targetSum) {
//        key值为前缀和，value为出现次数
        map = new HashMap<>();
//        定义为全局变量，可以少传一个参数
        target = targetSum;
//        前缀和为0的出现一次，为了节点的value直接等于target计数
        map.put(0L, 1);
        return help(root, 0L);
    }

    public static int help(TreeNode root, Long currentSum) {
//        结束条件，遍历到空节点的话，空节点的value为0
        if (root == null) return 0;

//        定义结果值
        int result = 0;
//        当前值求和
        currentSum += root.val;
//        从map查看是否有值为 currentSum - x = target 的，即x = currentSum - target,有的话直接加出现的次数，没有的话加+0
        result += map.getOrDefault(currentSum - target, 0);
//        将当前值总和加入map
        map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);

//        递归左右子树
        int left = help(root.left, currentSum);
        int right = help(root.right, currentSum);
//        求出总和
        result = result + left + right;
//        回溯，因为只能找父子节点，所以不能一直存入map
        map.put(currentSum, map.get(currentSum) - 1);
        return result;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(10,new TreeNode(5,new TreeNode(3,new TreeNode(3,null,null),new TreeNode(-2,null,null)),new TreeNode(2,null,new TreeNode(1,null,null))),new TreeNode(-3,null,new TreeNode(11,null,null)));
        int i = pathSum(a, 8);
        System.out.println(i);
    }
}

