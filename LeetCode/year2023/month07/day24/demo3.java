package month07.day24;

import java.util.PriorityQueue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/7/24 14:04
 */
public class demo3 {
    class MedianFinder {
        /**
         * initialize your data structure here.
         */
//        大顶堆与小顶堆，小顶堆默认创建就是小顶堆
        PriorityQueue<Integer> maxHeap;
        PriorityQueue<Integer> minHeap;

        public MedianFinder() {
            maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (maxHeap.size() == minHeap.size()) {
                minHeap.add(num);
                maxHeap.add(minHeap.poll());
            } else {
                maxHeap.add(num);
                minHeap.add(maxHeap.poll());
            }
        }

        public double findMedian() {
            if (maxHeap.size() == minHeap.size()) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else {
                return maxHeap.peek();
            }
        }
    }
}

