package LeetCode.month05.day20;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/5/20 11:38
 */
public class demo2 {
    public int getWinner(int[] arr, int k) {
        int res = arr[0];
        int winCount = 0;
        for (int i = 1; i < arr.length && winCount < k; i++) {
            if (res < arr[i]) {
                winCount = 0;
                res = arr[i];
            }
            winCount++;
        }
        return res;
    }
}

