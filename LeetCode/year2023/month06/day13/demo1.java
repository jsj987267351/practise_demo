package month06.day13;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/
 * @date 2023/6/13 14:59
 */
public class demo1 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
//        找到两个递增的分界线，右分界线就是答案
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
//                右边是递增的，往左找第一个递增节点，因为当前节点也有可能是递增的初始节点，所以直接赋值
                right = mid;
            } else {
//                左边是递增的，往右找第二个递增节点，当前节点一定不是第二个递增的初始节点，所以将下一个值赋给他
                left = mid + 1;
            }
        }
        return nums[left];
    }
}

