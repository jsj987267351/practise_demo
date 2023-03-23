package day02;


import java.util.Arrays;

public class demo1 {

    /**
     * 给你两个按 非递减顺序 排列的整数数组nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
     * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m] = nums2[n];
            m++;
        }
        Arrays.sort(nums1);
    }
}
