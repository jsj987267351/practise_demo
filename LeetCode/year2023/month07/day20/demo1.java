package month07.day20;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。
 * <p>
 * 环形数组 意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。
 * <p>
 * 子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-sum-circular-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/20 13:34
 */
public class demo1 {
    public int maxSubarraySumCircular(int[] nums) {
//        动态规划：首先求首尾不相连的情况的最大子数组和 max
//        然后求首尾相连的最大，首尾相连的最大就是 总和 - 首尾不相连的最小子数组和

//        变量： total:数组总和  max：首尾不相连的最大子数组和 ,min:首尾不相连的最小子数组和
        int total = 0, max = nums[0], min = nums[0], curMax = 0, curMin = 0;
        for (int num : nums) {
            curMax = Math.max(curMax + num, num);
            max = Math.max(max, curMax);
            curMin = Math.min(curMin + num, num);
            min = Math.min(min, curMin);
            total += num;
        }

//        特殊情况，如果max小于0的话，说明数组中都是负数，当前max就是所有负数中最大的那个，而min会=total，所以total - min=0
//        所以会不符合逻辑，进行特判
        return max > 0 ? Math.max(max, total - min) : max;
    }
}

