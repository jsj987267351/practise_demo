package month04.day11;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 * <p>
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 * <p>
 * 链接：https://leetcode.cn/problems/sorted-merge-lcci
 * @date 2023/4/11 18:09
 */
public class demo4 {
    public void merge1(int[] A, int m, int[] B, int n) {
        for (int i = m, j = 0; i < m + n; i++, j++) {
            A[i] = B[j];
        }
        Arrays.sort(A);
    }

    public void merge2(int[] A, int m, int[] B, int n) {
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                A[i] = B[i];
            }
            return;
        }
        int temp = m + n - 1;
        for (int i = m - 1, j = n - 1; j >= 0; ) {
            if (A[i] > B[j]) {
                A[temp] = A[i];
                i--;
                if (i < 0) {
                    for (int k = 0; k <= j; k++) {
                        A[k] = B[k];
                    }
                    break;
                }
            } else {
                A[temp] = B[j];
                j--;
            }
            temp--;
        }
    }

    public void merge(int[] A, int m, int[] B, int n) {
        int i = m - 1;
        int j = n - 1;
        int temp = m + n - 1;
        while (j >= 0) {
            if (i < 0 || A[i] < B[j]) {
                A[temp--] = B[j--];
            } else {
                A[temp--] = A[i--];
            }
        }
    }

}

