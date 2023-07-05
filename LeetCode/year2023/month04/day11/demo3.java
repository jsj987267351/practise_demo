package month04.day11;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 * https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * @date 2023/4/11 17:58
 */
public class demo3 {
    public int[] exchange(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        while (i < j) {
            if (nums[i] % 2 != 0) {
                i++;
                continue;
            }
            if (nums[j] % 2 == 0) {
                j--;
                continue;
            }
            swap(nums,i,j);
            i++;
            j--;
        }
        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

