package month11.day03;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/3 12:23
 */
public class demo4 {
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < nums1.length; i++) {
            nums1[i] = nums2[i - m];
        }
        Arrays.sort(nums1);
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = nums1.length;
        int index1 = m - 1, index2 = n - 1, index = length - 1;
        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] < nums2[index2]) {
                nums1[index--] = nums2[index2--];
            } else {
                nums1[index--] = nums1[index1--];
            }
        }
        if (index1 < 0) {
            while (index2 >= 0) {
                nums1[index--] = nums2[index2--];
            }
        }
    }
}

