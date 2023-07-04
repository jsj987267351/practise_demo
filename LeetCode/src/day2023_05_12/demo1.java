package day2023_05_12;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 * @date 2023/5/12 12:20
 */
public class demo1 {
    public int[] spiralOrder(int[][] matrix) {
//        空判断
        if (matrix.length==0){
            return new int[0];
        }
//        l 代表左边列 r代表右边列  t代表上边行 b代表下边行 x代表数组下标
        int l = 0 , r = matrix[0].length -1,t = 0 , b = matrix.length-1 , x = 0;
        int[] result = new int[(r + 1) * (b + 1)];

        while (true){
//            左到右
            for (int i = l; i <=r ; i++) {
                result[x++] = matrix[t][i];
            }
//            最上面一行已经打印过了，所以行向内收缩
            if (++t >b) break;
//            上到下
            for (int i = t; i <=b ; i++) {
                result[x++] = matrix[i][r];
            }
//            最右边一列打印过，向内收缩
            if (--r <l) break;
//            右到左
            for (int i = r; i >=l ; i--) {
                result[x++] = matrix[b][i];
            }
//            下边一行打印过，收缩
            if (--b <t) break;
//            下到上
            for (int i = b; i >=t ; i--) {
                result[x++] = matrix[i][l];
            }
//            左边一列打印过，收缩
            if (++l>r) break;

        }
        return result;
    }
}

