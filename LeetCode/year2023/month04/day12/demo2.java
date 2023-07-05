package month04.day12;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/
 * @date 2023/4/12 18:45
 */
public class demo2 {
    public int[] getLeastNumbers1(int[] arr, int k) {
        int[] result = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        int[] result = new int[k];

        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                   min = j;
                }
            }
            if (i != min) {
                swap(arr, i, min);
            }
        }
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

