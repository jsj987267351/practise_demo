package day48;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/5/21 15:06
 */
public class demo2 {
    public boolean searchMatrix(int[][] matrix, int target) {
//        做过的类似题，题目要求可以翻译为每行为递增，每列也为递增。
//        所以从左下角进行判断，因为左下角是当前行的最小值，也是当前列的最大值
//        大于 target 的话说明当前行都大于，行上移，小于target的话，说明当前列都小于，列右移
        int hang = matrix.length - 1, lie = 0;
        while (hang >= 0 && lie < matrix[0].length)
            if (matrix[hang][lie] < target) {
                lie++;
            } else if (matrix[hang][lie] > target) {
                hang--;
            } else return true;

        return false;
    }
}

