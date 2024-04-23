package LeetCode.month04.day17;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/4/17 11:27
 */
public class demo1 {
    class MyHashMap {

        int[] arr;

        public MyHashMap() {
            arr = new int[1000010];
            Arrays.fill(arr, -1);
        }

        public void put(int key, int value) {
            arr[key] = value;
        }

        public int get(int key) {
            return arr[key];
        }

        public void remove(int key) {
            arr[key] = -1;
        }
    }
}

