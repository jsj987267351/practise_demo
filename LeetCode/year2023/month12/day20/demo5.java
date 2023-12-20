package month12.day20;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/20 15:11
 */
public class demo5 {
    public int[] bestLine(int[][] points) {
        int max = 0;
        int[] res = new int[2];
        int length = points.length;
        for (int i = 0; i < length; i++) {
            int[] one = points[i];
            for (int j = i + 1; j < length; j++) {
                int[] two = points[j];
                int curMax = 2;
                for (int k = j + 1; k < length; k++) {
                    int[] three = points[k];
                    int xie1 = (three[0] - two[0]) * (two[1] - one[1]);
                    int xie2 = (three[1] - two[1]) * (two[0] - one[0]);
                    if (xie1 == xie2) curMax++;
                }
                if (curMax > max) {
                    max = curMax;
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }
}

