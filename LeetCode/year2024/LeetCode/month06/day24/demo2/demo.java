package LeetCode.month06.day24.demo2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/24 9:56
 */
public class demo {
    Map<Long, Integer> map = new HashMap<>();
    int target;

    public int pathSum(TreeNode root, int targetSum) {
        map.put(0L, 1);
        target = targetSum;
        return backtracking(root, 0L);
    }

    public int backtracking(TreeNode root, Long curSum) {
        if (root == null) return 0;
        int res = 0;
        curSum += root.val;
        res += map.getOrDefault(curSum - target, 0);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        res += backtracking(root.left, curSum);
        res += backtracking(root.right, curSum);
        map.put(curSum, map.get(curSum) - 1);
        return res;
    }
}

