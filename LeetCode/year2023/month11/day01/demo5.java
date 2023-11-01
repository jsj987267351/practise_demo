package month11.day01;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/1 13:41
 */
public class demo5 {
    public int removeDuplicates(int[] nums) {
        int left = 0, right = 1;
        while (right < nums.length) {
            if (nums[left] != nums[right]) {
                nums[++left] = nums[right];
            }
            right++;
        }
        return left + 1;
    }
}

