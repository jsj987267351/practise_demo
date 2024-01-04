package LeetCode.month01.day04;


import java.util.LinkedList;
import java.util.Stack;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/4 12:21
 */
public class demo1 {
    class StockSpanner {
        //        [i,j]，i表示第几天，j表示当天股票价格
        LinkedList<int[]> stack;
        //        index表示当前是第几天
        int index;

        public StockSpanner() {
            stack = new LinkedList<>();
//            初始放入一个值，防止栈空，因为最后要与左边第一个比当前价格高的天数求差，所以直接放入-1，价格为最高防止被弹出
            stack.push(new int[]{-1, Integer.MAX_VALUE});
            index = -1;
        }

        public int next(int price) {
            index++;
//            把连续不符合要求的都弹出，这样栈顶就是左边第一个符合要求的
            while (price >= stack.peek()[1]) {
                stack.poll();
            }
//            求出天数差即可,后续加新的股票价格时，有两种可能，一种时大于等于栈顶，一个小于栈顶
//            如果大于等于栈顶的话那么也一定大于当前栈顶之前弹出的所有，所以之前的可以直接弹出
            int res = index - stack.peek()[0];
//            将当前天加入
            stack.push(new int[]{index, price});
            return res;
        }
    }
}

