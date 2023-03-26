package day10;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * @date 2023/3/26 15:42
 */
public class demo2 {
    public void rotate(int[] nums, int k) {
        int[] result = new int[nums.length + k];
        for (int i = 0; i < nums.length; i++) {
            result[i + k] = nums[i];
        }

        int i  = k-1;
        int j  = result.length -1;
        while (i>=0){
            result[i] = result[j];
            i--;
            j--;
        }
        for (int l = 0; l < nums.length; l++) {
            nums[l] = result[l];
        }
    }
}

