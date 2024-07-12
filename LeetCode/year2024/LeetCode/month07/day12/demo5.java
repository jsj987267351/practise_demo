package LeetCode.month07.day12;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/12 10:10
 */
public class demo5 {
    class SmallestInfiniteSet {
        boolean[] used;
        int index;

        public SmallestInfiniteSet() {
            used = new boolean[1001];
            Arrays.fill(used, true);
            index = 1;
        }

        public int popSmallest() {
            while (index < used.length && !used[index]) {
                index++;
            }
            used[index] = false;
            return index;
        }

        public void addBack(int num) {
            used[num] = true;
            index = Math.min(index, num);
        }
    }
}

