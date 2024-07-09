package LeetCode.month07.day09;

import java.util.LinkedList;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/9 10:19
 */
public class demo5 {
    class StockSpanner {
        LinkedList<int[]> stack;

        public StockSpanner() {
            stack = new LinkedList<>();
        }

        public int next(int price) {
            int res = 1;
            while (!stack.isEmpty() && price >= stack.peek()[0]) {
                res += stack.pop()[1];
            }
            stack.push(new int[]{price, res});
            return res;
        }
    }
}

