package LeetCode.month01.day08;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/8 12:45
 */
public class demo6 {
    class SmallestInfiniteSet {
        boolean[] exist;
        int index;

        public SmallestInfiniteSet() {
            exist = new boolean[1001];
            index = 1;
        }

        public int popSmallest() {
            while (exist[index]) {
                index++;
            }
            exist[index] = true;
            return index;
        }

        public void addBack(int num) {
            if (exist[num]) {
                exist[num] = false;
            }
            index = Math.min(index, num);
        }
    }
}

