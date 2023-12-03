package month12.day03;

import java.util.PriorityQueue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/3 14:19
 */
public class demo4 {
    class MedianFinder {
        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> MaxHeap;

        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            MaxHeap = new PriorityQueue<>((a, b) -> b - a);
        }

        public void addNum(int num) {
            if (minHeap.size() < MaxHeap.size()) {
                MaxHeap.offer(num);
                minHeap.offer(MaxHeap.poll());
            } else {
                minHeap.offer(num);
                MaxHeap.offer(minHeap.poll());
            }
        }

        public double findMedian() {
            if (minHeap.size() == MaxHeap.size()) {
                return (minHeap.peek() + MaxHeap.peek()) / 2.0;
            } else {
                return MaxHeap.peek();
            }
        }
    }
}

