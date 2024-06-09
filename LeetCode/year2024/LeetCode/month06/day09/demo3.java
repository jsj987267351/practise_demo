package LeetCode.month06.day09;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/9 17:49
 */
public class demo3 {
    public int removeDuplicates(int[] nums) {
        int left = 0,right = 1;
        while (right < nums.length){
            if (nums[right] != nums[left]){
                nums[++left] = nums[right];
            }
            right++;
        }
        return left +1;
    }
}

