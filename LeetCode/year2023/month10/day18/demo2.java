package month10.day18;

import java.util.PriorityQueue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/kth-largest-element-in-an-array/description/?envType=list&envId=RxT23Yqb
 * @date 2023/10/18 12:09
 */
public class demo2 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> MinHeap = new PriorityQueue<>();
        for (int num : nums) {
            if (MinHeap.size() < k) {
                MinHeap.add(num);
            } else if (MinHeap.peek() < num) {
                MinHeap.poll();
                MinHeap.add(num);
            }
        }
        return MinHeap.peek();
    }
}

