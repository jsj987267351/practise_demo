package month10.day16;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/sort-colors/?envType=list&envId=hliQiQFH
 * @date 2023/10/16 13:19
 */
public class demo4 {
    public void sortColors(int[] nums) {
        int red = 0, blue = nums.length - 1;
        int index = 0;
        while (index <= blue) {
            if (nums[index] == 0) {
                swap(nums, index, red);
                red++;
                index++;
            } else if (nums[index] == 2) {
                swap(nums, index, blue);
                blue--;
            } else {
                index++;
            }
        }
    }

    public void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}

