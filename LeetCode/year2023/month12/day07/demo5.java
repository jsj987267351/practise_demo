package month12.day07;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/7 14:38
 */
public class demo5 {
    class TripleInOne {
        int[] data;
        int[] index;
        int size;

        public TripleInOne(int stackSize) {
            size = stackSize;
            data = new int[size * 3];
            index = new int[3];
            index[1] = size;
            index[2] = size * 2;
        }

        public void push(int stackNum, int value) {
            int ind = index[stackNum];
            if (ind == (stackNum + 1) * size){
                return;
            }
            data[ind] = value;
            index[stackNum]++;
        }

        public int pop(int stackNum) {
            int ind = index[stackNum];
            if (ind == stackNum * size) {
                return -1;
            }
            int res = data[ind -1];
            index[stackNum]--;
            return res;
        }

        public int peek(int stackNum) {
            int ind = index[stackNum];
            if (ind == stackNum * size) {
                return -1;
            }
            return data[ind -1];
        }

        public boolean isEmpty(int stackNum) {
            return index[stackNum] == stackNum * size;
        }
    }
}

