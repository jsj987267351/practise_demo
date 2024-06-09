package LeetCode.month06.day09;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/9 18:37
 */
public class demo9 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length - 1, left = m - 1, right = n - 1;
        while (index >= 0) {
            if (left < 0) {
                nums1[index--] = nums2[right--];
            } else if (right < 0) {
                nums1[index--] = nums1[left--];
            } else if (nums1[left] < nums2[right]) {
                nums1[index--] = nums2[right--];
            } else {
                nums1[index--] = nums1[left--];
            }
        }
    }
}

