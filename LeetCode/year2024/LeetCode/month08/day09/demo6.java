package LeetCode.month08.day09;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/8/9 11:29
 */
public class demo6 {
    public int getWinner(int[] arr, int k) {
        int res = arr[0], winCount = 0;
        for (int i = 1; i < arr.length && winCount < k; i++) {
            if (res < arr[i]) {
                res = arr[i];
                winCount = 0;
            }
            winCount++;
        }
        return res;
    }
}

