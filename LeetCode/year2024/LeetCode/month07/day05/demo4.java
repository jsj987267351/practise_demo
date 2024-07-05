package LeetCode.month07.day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/5 9:58
 */
public class demo4 {

    public static void main(String[] args) {
        int a[] = new int[]{1, 1, 2};
        int b[] = new int[]{1, 2, 3};
        System.out.println(kSmallestPairs(a, b, 2));
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> nums1[a[0]] + nums2[a[1]] - (nums1[b[0]] + nums2[b[1]]));
        int len1 = nums1.length;
        int len2 = nums2.length;
        for (int i = 0; i < Math.min(len2, k); i++) {
            minHeap.offer(new int[]{0, i});
        }
        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] min = minHeap.poll();
            res.add(Arrays.asList(nums1[min[0]], nums2[min[1]]));
            if (++min[0] < len1) {
                minHeap.offer(min);
            }
        }
        return res;
    }
}

