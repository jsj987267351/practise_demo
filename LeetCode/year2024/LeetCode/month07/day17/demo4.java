package LeetCode.month07.day17;

import java.util.ArrayDeque;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/17 10:12
 */
public class demo4 {
    public int[] canSeePersonsCount(int[] heights) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int len = heights.length;
        int[] res = new int[len];
        for (int i = len-1; i >=0 ; i--) {
            while (!deque.isEmpty() && heights[i] >= heights[deque.peek()]){
                res[i]++;
                deque.pop();
            }
            if (!deque.isEmpty()){
                res[i]++;
            }
            deque.push(i);
        }
        return res;
    }
}

