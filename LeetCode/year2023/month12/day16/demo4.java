package month12.day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/16 18:03
 */
public class demo4 {
    public List<List<Integer>> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> MinHeap = new PriorityQueue<>((a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]));
        int length1 = nums1.length;
        int length2 = nums2.length;
        for (int i = 0; i < Math.min(k, length1); i++) {
            MinHeap.offer(new int[]{i, 0});
        }
        while (k-- > 0 && !MinHeap.isEmpty()) {
            int[] poll = MinHeap.poll();
            res.add(Arrays.asList(nums1[poll[0]], nums2[poll[1]]));
            if (++poll[1] < length2) {
                MinHeap.offer(poll);
            }
        }
        return res;
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> MaxHeap = new PriorityQueue<>((a, b) -> (b[0] + b[1]) - (a[0] + a[1]));
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            for (int j = 0; j < Math.min(k, nums2.length); j++) {
                if (MaxHeap.size() < k) {
                    MaxHeap.offer(new int[]{nums1[i], nums2[j]});
                } else {
                    int[] peek = MaxHeap.peek();
                    if ((nums1[i] + nums2[j]) < (peek[0] + peek[1])) {
                        MaxHeap.poll();
                        MaxHeap.offer(new int[]{nums1[i], nums2[j]});
                    }
                }
            }
        }
        while (!MaxHeap.isEmpty()) {
            int[] poll = MaxHeap.poll();
            res.add(Arrays.asList(poll[0], poll[1]));
        }
        return res;
    }
}

