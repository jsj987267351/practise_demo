package LeetCode.month07.day01;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/1 10:18
 */
public class demo7 {
    public void merge(int[] A, int m, int[] B, int n) {
        int index = A.length - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (A[m] > B[n]) {
                A[index--] = A[m--];
            } else {
                A[index--] = B[n--];
            }
        }
        while (m >= 0) {
            A[index--] = A[m--];
        }
        while (n >= 0) {
            A[index--] = B[n--];
        }
    }
}

