package month06.day27;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 * <p>
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 * <p>
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/6/27 12:46
 */
public class demo1 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int sum = 0;
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] -= 2 * nums[i];
                k--;
            } else {
                break;
            }
        }

        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }

        if (k == 0) {
            return sum;
        } else {
            Arrays.sort(nums);
            if (k % 2 == 0) {
                return sum;
            } else {
                sum -= 2 * nums[0];
                return sum;
            }
        }
    }
}

