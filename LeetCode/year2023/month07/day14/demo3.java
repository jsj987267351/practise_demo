package month07.day14;

import java.util.PriorityQueue;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/find-median-from-data-stream/?envType=study-plan-v2&envId=top-100-liked
 *   解题https://www.bilibili.com/video/BV1Lv4y1e7HL?p=143&vd_source=943ca493b937adf4b7a5aae3a4f3f14f
 * @date 2023/7/14 17:30
 */
public class demo3 {

    class MedianFinder {
//        大顶堆与小顶堆，小顶堆默认创建就是小顶堆
        PriorityQueue<Integer> maxHeap;
        PriorityQueue<Integer> minHeap;
        public MedianFinder() {
            maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
            minHeap = new PriorityQueue<>();
        }

//        每次添加元素时，如果两个堆的大小相等，就往大顶堆加，否则往小顶堆加
        public void addNum(int num) {
            if (maxHeap.size() == minHeap.size()){
//                往大顶堆加的时候，先将该元素加入小顶堆排序，然后把小顶堆的最大值放入大顶堆
                minHeap.offer(num);
                maxHeap.offer(minHeap.poll());
            }else {
                maxHeap.offer(num);
                minHeap.offer(maxHeap.poll());
            }
        }

        public double findMedian() {
//            相等的话直接取中位数 否则取大顶堆，因为大顶堆的大小>=小顶堆
            if (maxHeap.size() == minHeap.size()){
                return (maxHeap.peek() + minHeap.peek())/2.0;
            }else {
                return maxHeap.peek();
            }
        }
    }
}

