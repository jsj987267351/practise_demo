package month08.day24;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/submissions/?envType=study-plan-v2&envId=top-interview-150
 * @date 2023/8/24 12:01
 */
public class demo2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] ints = new int[(m + n) / 2 + 1];
        int i = 0, j = 0, index = 0;
        while (i < m && j < n && (i + j) <= (m + n) / 2) {
            if (nums1[i] < nums2[j]) {
                ints[index++] = nums1[i++];
            } else {
                ints[index++] = nums2[j++];
            }
        }
//        有可能因为两个数组长度差异较大导致还未放到一半
        while (i == m && (i + j) <= (m + n) / 2) {
            ints[index++] = nums2[j++];
        }

        while (j == n && (i + j) <= (m + n) / 2) {
            ints[index++] = nums1[i++];
        }

        if ((m + n) % 2 == 0) {
            return (ints[index - 1] + ints[index - 2]) / 2.0;
        } else {
            return (double) ints[index - 1];
        }
    }
}

