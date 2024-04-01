package LeetCode.month03.day20;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/3/20 15:38
 */
public class demo {
    public int maximumScore(int[] nums, int k) {
        int res = nums[k], minHeight = nums[k];
        int len = nums.length;
        int left = k, right = k;
//        从k点向左右扩散，扩散途中更新结果，因为k本身不动，所以要扩散 len-1 次
        for (int i = 0; i < len - 1; i++) {
//            向左扩散的情况，右边到头了或者左边扩散的值比右边扩散的值更大。也即是往边缘值更大的扩散
//            因为扩散一步的话，扩散长度一定，但是往小的扩散的话宽度会更小，往大的扩散宽度不变，总体更大
            if (right == len - 1 || left > 0 && nums[left - 1] > nums[right + 1]) {
                left--;
                minHeight = Math.min(minHeight, nums[left]);
            } else {
                right++;
                minHeight = Math.min(minHeight, nums[right]);
            }
            res = Math.max(res, minHeight * (right - left + 1));
        }
        return res;
    }
}

