package month11.day20;

import java.time.OffsetDateTime;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/20 12:42
 */
public class demo3 {
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
            if (queue1.isEmpty()) {
                return -1;
            }
            return max;
        }

        public void add(int value) {
            if (value > max) {
                max = value;
            }
            queue1.add(value);
        }

        public int remove() {
            if (queue1.isEmpty()) {
                return -1;
            }
            int res = queue1.poll();
            if (res == max) {
                max = Integer.MIN_VALUE;
                while (!queue1.isEmpty()) {
                    if (queue1.peek() > max) {
                        max = queue1.peek();
                    }
                    queue2.add(queue1.poll());
                }
                while (!queue2.isEmpty()) {
                    queue1.add(queue2.poll());
                }
            }
            return res;

        }
    }
}

