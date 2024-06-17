package LeetCode.month06.day17;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/17 14:35
 */
public class demo9 {
    class Checkout {
        Queue<Integer> queue1;
        Queue<Integer> queue2;
        int max;

        public Checkout() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
            max = Integer.MIN_VALUE;
        }

        public int get_max() {
            if (queue1.isEmpty()) return -1;
            return max;
        }

        public void add(int value) {
            if (value > max) max = value;
            queue1.add(value);
        }

        public int remove() {
            if (queue1.isEmpty()) return -1;
            int res = queue1.poll();
            if (max == res) {
                max = Integer.MIN_VALUE;
                while (!queue1.isEmpty()) {
                    int cur = queue1.poll();
                    max = Math.max(max, cur);
                    queue2.add(cur);
                }
                while (!queue2.isEmpty()) {
                    queue1.add(queue2.poll());
                }

            }
            return res;
        }
    }
}

