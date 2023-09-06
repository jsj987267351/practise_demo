package month09.day06.demo1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/paths-with-sum-lcci/description/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/9/6 12:03
 */
public class demo {

    Map<Long, Integer> map;
    int targetSum;

    public int pathSum(TreeNode root, int sum) {
        map = new HashMap<>();
        targetSum = sum;
        map.put(0L, 1);
        return help(root, 0L);
    }

    public int help(TreeNode root, Long currentSum) {
        if (root == null) return 0;
        currentSum += root.val;
        int res = 0;
        res += map.getOrDefault(currentSum - targetSum, 0);
        map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);

        int left = help(root.left, currentSum);
        int right = help(root.right, currentSum);

        res = res + left + right;
        map.put(currentSum, map.get(currentSum) - 1);
        return res;
    }
}

