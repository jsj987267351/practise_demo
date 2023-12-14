package month12.day14;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/14 16:51
 */
public class demo4 {
    public void merge(int[] A, int m, int[] B, int n) {
        int length = A.length;
        int index = length - 1;
        int left = m - 1, right = n - 1;
        while (right >= 0) {
            if (left < 0 || A[left] < B[right]) {
                A[index--] = B[right--];
            } else {
                A[index--] = A[left--];
            }
        }
    }
}

