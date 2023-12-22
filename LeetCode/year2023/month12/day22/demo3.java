package month12.day22;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/22 14:19
 */
public class demo3 {
    public int maxPoints(int[][] points) {
        int length = points.length;
        int res = 1;
        for (int i = 0; i < length; i++) {
            int[] one = points[i];
            for (int j = i + 1; j < length; j++) {
                int[] two = points[j];
                int curSum = 2;
                for (int k = j + 1; k < length; k++) {
                    int[] three = points[k];
                    int xieLv1 = (three[1] - two[1]) * (two[0] - one[0]);
                    int xieLv2 = (two[1] - one[1]) * (three[0] - two[0]);
                    if (xieLv1 == xieLv2) {
                        curSum++;
                    }
                }
                res = Math.max(res, curSum);
            }
        }
        return res;
    }
}

