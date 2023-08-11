package month08.day11;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。
 * <p>
 * 请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。
 * https://leetcode.cn/problems/matrix-diagonal-sum/description/
 * @date 2023/8/11 14:29
 */
public class demo1 {
    public int diagonalSum(int[][] mat) {
        int length = mat.length;
        int res = 0;
        for (int i = 0; i < length; i++) {
            res += mat[i][i];
            if (i != length - i-1){
                res+=mat[i][length-i-1];
            }
        }
        return res;
    }
}

