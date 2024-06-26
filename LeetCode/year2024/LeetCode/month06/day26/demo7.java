package LeetCode.month06.day26;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/26 10:32
 */
public class demo7 {
    class TripleInOne {
        int[] data;
        int[] index;
        int size;

        public TripleInOne(int stackSize) {
            data = new int[stackSize * 3];
            index = new int[3];
            index[1] = stackSize;
            index[2] = stackSize * 2;
            size = stackSize;
        }

        public void push(int stackNum, int value) {
            if (index[stackNum] == (stackNum + 1) * size) return;
            data[index[stackNum]++] = value;
        }

        public int pop(int stackNum) {
            if (isEmpty(stackNum)) return -1;
            return data[--index[stackNum]];
        }

        public int peek(int stackNum) {
            if (isEmpty(stackNum)) return -1;
            return data[index[stackNum] - 1];
        }

        public boolean isEmpty(int stackNum) {
            return index[stackNum] == stackNum * size;
        }
    }
}

