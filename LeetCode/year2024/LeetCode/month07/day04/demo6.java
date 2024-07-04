package LeetCode.month07.day04;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/4 10:24
 */
public class demo6 {
    public int maxPoints(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            int[] one = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] two = points[j];
                int curMax = 2;
                for (int k = j + 1; k < points.length; k++) {
                    int[] three = points[k];
                    int xie1 = (two[1] - one[1]) * (three[0] - two[0]);
                    int xie2 = (three[1] - two[1]) * (two[0] - one[0]);
                    if (xie1 == xie2) {
                        curMax++;
                    }
                }
                res = Math.max(res, curMax);
            }
        }
        return res;
    }
}

