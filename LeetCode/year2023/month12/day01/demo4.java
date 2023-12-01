package month12.day01;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/1 12:59
 */
public class demo4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] res = new int[(length1 + length2) / 2 + 1];
        int i = 0, j = 0, index = 0;
        while (i < length1 && j < length2 && index < res.length) {
            if (nums1[i] < nums2[j]) {
                res[index++] = nums1[i++];
            } else {
                res[index++] = nums2[j++];
            }
        }
        while (i == length1 && index < res.length) {
            res[index++] = nums2[j++];
        }
        while (j == length2 && index < res.length) {
            res[index++] = nums1[i++];
        }
        if ((length1 + length2) % 2 == 0) {
            return (res[index - 1] + res[index - 2]) / 2.0;
        } else {
            return res[index - 1];
        }
    }
}

