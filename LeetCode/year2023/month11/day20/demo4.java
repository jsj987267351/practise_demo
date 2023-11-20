package month11.day20;


import java.util.LinkedList;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/20 12:51
 */
public class demo4 {
    public boolean validateBookSequences(int[] putIn, int[] takeOut) {
        LinkedList<Integer> stack = new LinkedList<>();
        int index = 0;
        for (int put : putIn) {
            stack.push(put);
            while (!stack.isEmpty() && stack.peek().equals(takeOut[index])) {
                index++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}

