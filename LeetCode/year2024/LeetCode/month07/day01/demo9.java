package LeetCode.month07.day01;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/1 10:34
 */
public class demo9 {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[]{};
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        int[] res = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            res[i] = i * longer + (k - i) * shorter;
        }
        return res;
    }
}

