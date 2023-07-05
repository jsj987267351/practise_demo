package month03.day25;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1
 * https://leetcode.cn/problems/binary-search/
 * @date 2023/3/25 17:46
 */
public class demo1 {
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return -1;
    }

    public int search1(int[] nums, int target) {
        int i = 0, j = nums.length;
        while (i < j) {
            int m = (i + j) >>> 1;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                i = m + 1;
            } else {
                j = m;
            }
        }
        return -1;
    }

}

