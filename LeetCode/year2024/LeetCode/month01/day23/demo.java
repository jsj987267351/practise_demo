package LeetCode.month01.day23;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/23 10:49
 */
public class demo {
    public int alternatingSubarray(int[] nums) {
        int res = -1, left = 0, right = 0;
        int length = nums.length;
        while (right < length - 1) {
            if (nums[right] + 1 != nums[right + 1]) {
                right++;
                continue;
            }
//            当前位置就是起始位置，记录
            left = right;
//            right 和 right+1已经符合条件，从+2开始判断,以left为0，偶数位置相同，奇数位置为偶数位置数字+1
//            right-left 就是以left为0时right的相对位置，相同代表偶数就+0，否则+1，所以用位置对2取余
            right += 2;
            while (right < length && nums[right] == nums[left] + (right - left) % 2) {
                right++;
            }
//            此时的right为第一个不符合条件的下标位置
            res = Math.max(res, right - left);
//            当前right前一个数字可能为另一个新的交替数组的第一个数字，所以回调一位
            right--;
        }
        return res;
    }
}

