package month12.day25;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/25 14:02
 */
public class demo2 {
    public int[] subSort(int[] array) {
        int start = -1, end = -1, length = array.length, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            if (array[i] >= max) {
                max = array[i];
            } else {
                end = i;
            }
            if (array[length - i - 1] <= min) {
                min = array[length - i - 1];
            } else {
                start = length - i - 1;
            }
        }
        return new int[]{start, end};
    }
}

