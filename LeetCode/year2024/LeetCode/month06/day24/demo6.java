package LeetCode.month06.day24;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/24 11:15
 */
public class demo6 {
    public static void main(String[] args) {
        int[] a = {0, 0, 0, 0, 0};
        int[] b = {-1, 0, 0, 0, 0, 0, 1};
        System.out.println(findMedianSortedArrays(a, b));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        boolean flag = (len1 + len2) % 2 == 0;
        int len = (len1 + len2) / 2 + 1;
        int[] res = new int[len];
        int index = 0, left = 0, right = 0;
        while (index < len && left < len1 && right < len2) {
            if (nums1[left] < nums2[right]) {
                res[index++] = nums1[left++];
            } else {
                res[index++] = nums2[right++];
            }
        }
        while (index < len && left < len1) {
            res[index++] = nums1[left++];
        }
        while (index < len && right < len2) {
            res[index++] = nums2[right++];
        }
        return flag ? (res[len - 1] + res[len - 2]) / 2.0 : res[len - 1];
    }
}

