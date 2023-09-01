package month09.day01;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description 三合一。描述如何只用一个数组来实现三个栈。
 * <p>
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
 * <p>
 * 构造函数会传入一个stackSize参数，代表每个栈的大小。
 * @date 2023/9/1 12:07
 */
public class demo1 {

    class TripleInOne {
        int[] data;
        //        存储每个栈顶在数组中所在的位置
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
//            检查下标是否越界
            if (ind < (stackNum + 1) * size) {
                data[ind] = value;
                index[stackNum]++;
            }
        }

        public int pop(int stackNum) {
//            检查是否该下标为空
            int ind = index[stackNum];
            if (ind > stackNum * size) {
                index[stackNum]--;
                return data[ind - 1];
            } else {
                return -1;
            }
        }

        public int peek(int stackNum) {
            int ind = index[stackNum];
            if (ind > stackNum * size) {
                return data[ind - 1];
            } else {
                return -1;
            }
        }

        public boolean isEmpty(int stackNum) {
            return index[stackNum] == stackNum * size;
        }
    }
}

