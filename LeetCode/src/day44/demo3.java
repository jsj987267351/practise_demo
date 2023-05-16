package day44;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sort-colors
 * @date 2023/5/16 16:32
 */
public class demo3 {
    public void sortColors(int[] nums) {
        int zero = 0, two = nums.length - 1;
        int i = 0;
        while (i <= two) {
            if (nums[i] == 0) {
                swap(nums, zero, i);
                zero++;
//                传递过来的不可能是0，所以i需要++
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, two);
//                传递过来的可能还是2，所以i不能++
                two--;
            } else {
                i++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

