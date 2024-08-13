package LeetCode.month08.day09;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/8/9 11:07
 */
public class demo4 {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int left = 0, right = plants.length - 1, res = 0;
        int sizea = capacityA, sizeb = capacityB;
        while (left <= right) {
            if (left == right) {
                int max = Math.max(capacityA, capacityB);
                if (max < plants[left]) {
                    res++;
                }
                break;
            }
            if (capacityA < plants[left]) {
                res++;
                capacityA = sizea;
            }
            capacityA -= plants[left];
            left++;
            if (capacityB < plants[right]) {
                res++;
                capacityB = sizeb;
            }
            capacityB -= plants[right];
            right--;
        }
        return res;
    }
}

