package month06.day05;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/search-a-2d-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/6/5 13:48
 */
public class demo1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int length = matrix[0].length;
//        左下角的值作为基准,因为该值为当前行的最小值以及当前列的最大值
        int i = matrix.length-1, j = 0;
        while (i>=0 && j <length){
            if (matrix[i][j] > target){
//                说明当前行的最小值都大于，所以行数-1
                i--;
            }else if (matrix[i][j] < target){
//                说明当前列的最大值都小于，所以列数+1
                j++;
            }else return true;
        }
        return false;
    }
}

