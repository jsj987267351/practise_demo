package month09.day18;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/9/18 12:41
 */
public class demo2 {
    public int[] bestLine(int[][] points) {
//        与149题同理，暴力枚举，只不过最终结果返回的是前两位序号
        int max = 0;
        int[] res = new int[2];
        int len = points.length;
        for (int i = 0; i < len; i++) {
            int[] one = points[i];
            for (int j = i + 1; j < len; j++) {
                int[] two = points[j];
                int curSum = 2;
                for (int k = j + 1; k < len; k++) {
                    int[] three = points[k];
                    int xielv1 = (three[1] - two[1]) * (two[0] - one[0]);
                    int xielv2 = (three[0] - two[0]) * (two[1] - one[1]);
                    if (xielv1 == xielv2) curSum++;
                }
                if (curSum > max) {
                    max = curSum;
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }
}

