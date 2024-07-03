package LeetCode.month07.day03;



/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/3 10:58
 */
public class demo9 {
    public int[] bestLine(int[][] points) {
        int max = 0;
        int[] res = new int[2];
        for (int i = 0; i < points.length; i++) {
            int[] first = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] second = points[j];
                int curLen = 2;
                for (int k = j + 1; k < points.length; k++) {
                    int[] three = points[k];
                    int xie1 = (second[1] - first[1]) * (three[0] - second[0]);
                    int xie2 = (three[1] - second[1]) * (second[0] - first[0]);
                    if (xie1 == xie2) {
                        curLen++;
                    }
                }
                if (curLen > max) {
                    max = curLen;
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }
}

