package day64;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 * 测试用例的答案是一个 32-位 整数。
 * <p>
 * 子数组 是数组的连续子序列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/6/16 14:17
 */
public class demo2 {
    public int maxProduct(int[] nums) {
//        curMax为前一个计算到的最大值  curMin为前一最小值,记录前一最小值的原因是如果遇到了负数，那么最小值乘该负数就会变成最大值，最大值乘该负数会变成最小值。
//        所以遇到负数时将二者交换一下即可
        int max = Integer.MIN_VALUE, preMax = 1, preMin = 1;
//        进行从头到尾遍历数组
        for (int i = 0; i < nums.length; i++) {
//            如果遇到了负数，将最大值与最小值进行交换即可
            if (nums[i] < 0) {
                int temp = preMax;
                preMax = preMin;
                preMin = temp;
            }
//            此时更新后即为当前的最大值与最小值
            preMax = Math.max(preMax * nums[i], nums[i]);
            preMin = Math.min(preMin * nums[i], nums[i]);

            max = Math.max(max, preMax);
        }
        return max;
    }
}

