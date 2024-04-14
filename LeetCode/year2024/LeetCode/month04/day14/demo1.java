package LeetCode.month04.day14;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/4/14 11:33
 */
public class demo1 {
    public int findChampion(int n, int[][] edges) {
        boolean[] win = new boolean[n];
        for (int row = 0; row < edges.length; row++) {
            win[edges[row][1]] = true;
        }
        int res = 0, count = 0;
        for (int i = 0; i < n; i++) {
            if (!win[i]) {
                count++;
                res = i;
            }
            if (count > 1) return -1;
        }
        return res;
    }
}

