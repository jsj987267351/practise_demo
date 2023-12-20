package month12.day20;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/20 14:11
 */
public class demo2 {
    public int[] findPeakGrid(int[][] mat) {
        int max = -1;
        int[] res = new int[2];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] > max){
                    max = mat[i][j];
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }
}

