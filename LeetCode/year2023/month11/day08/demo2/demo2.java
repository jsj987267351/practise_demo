package month11.day08.demo2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/8 13:09
 */
public class demo2 {
    int target;
    Map<Long, Integer> map;

    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        map = new HashMap<>();
        map.put(0L, 1);
        return preSum(root, 0);
    }
//       从根节点到当前节点的前缀和
    public int preSum(TreeNode root, long curSum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        curSum += root.val;
        res += map.getOrDefault(curSum - target, 0);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        int left = preSum(root.left, curSum);
        int right = preSum(root.right, curSum);
        res += left + right;
        map.put(curSum, map.get(curSum) - 1);
        return res;
    }
}

