package LeetCode.month04.day14;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/4/14 11:36
 */
public class demo2 {
    class MyHashSet {
        boolean[] used;

        public MyHashSet() {
            used = new boolean[1000010];
        }

        public void add(int key) {
            used[key] = true;
        }

        public void remove(int key) {
            used[key] = false;
        }

        public boolean contains(int key) {
            return used[key];
        }

    }
}

