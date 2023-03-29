package day11;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 * @date 2023/3/29 13:02
 */
public class demo1 {
    public int removeDuplicates1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = nums.length;
        for (int i = 1; i < result; ) {
            if (nums[i - 1] == nums[i]) {
                for (int j = i; j < result - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                result--;
            } else {
                i++;
            }
        }
        return result;
    }


    public int removeDuplicates(int[] nums) {
        int p = 0;
        int q = 1;
        while (q< nums.length){
            if(nums[p]!= nums[q]){
                nums[p+1] = nums[q];
                p++;
            }
            q++;

        }
        return p+1;
}
}

