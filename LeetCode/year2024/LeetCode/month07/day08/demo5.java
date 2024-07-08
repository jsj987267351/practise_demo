package LeetCode.month07.day08;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/8 9:57
 */
public class demo5 {
    public int[] subSort(int[] array) {
        int start = -1, end = -1, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, len = array.length;
        for (int i = 0; i < len; i++) {
            if (array[i] >= max) {
                max = array[i];
            } else {
                end = i;
            }
            if (array[len - i - 1] <= min) {
                min = array[len - i - 1];
            } else {
                start = len - i - 1;
            }
        }
        return new int[]{start, end};
    }
}

