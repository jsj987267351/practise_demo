package month08.day05;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 峰值元素是指其值严格大于左右相邻值的元素。
 * <p>
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * <p>
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * <p>
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-peak-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/8/5 18:56
 */
public class demo1 {
    public int findPeakElement(int[] nums) {
//        二分查找，进行爬坡法
        int left = 0, right = nums.length -1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
//                如果当前值比右边小，说明右边一定有更大的
                left = mid + 1;
            } else {
//                否则说明左边有更大的，并且当前mid也有可能是最大的
                right = mid;
            }
        }
        return left;
    }
}

