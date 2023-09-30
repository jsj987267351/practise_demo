package month09.day30;

import java.util.PriorityQueue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/continuous-median-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/9/30 16:46
 */
public class demo2 {
    class MedianFinder {
        PriorityQueue<Integer> small;
        PriorityQueue<Integer> big;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            big = new PriorityQueue<>((a, b) -> b - a);
            small = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (big.size() == small.size()) {
                big.add(num);
                small.add(big.poll());
            } else {
                small.add(num);
                big.add(small.poll());
            }
        }

        public double findMedian() {
            if (small.size() == big.size()) {
                return (small.peek() + big.peek()) / 2.0;
            } else {
                return small.peek() / 1.0;
            }
        }
    }
}

