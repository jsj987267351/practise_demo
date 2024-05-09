package LeetCode.month05.day09;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/5/9 12:05
 */
public class demo2 {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int res = 0, left = 0, right = plants.length - 1;
        int A = capacityA, B = capacityB;
        while (left <= right) {
            if (left == right) {
                if (A >= B && A < plants[left] || (B > A && B < plants[left])) {
                    res++;
                }
                break;
            }
            if (A < plants[left]) {
                res++;
                A = capacityA;
            }
            A -= plants[left];
            left++;
            if (B < plants[right]) {
                res++;
                B = capacityB;
            }
            B -= plants[right];
            right--;
        }
        return res;
    }
}

