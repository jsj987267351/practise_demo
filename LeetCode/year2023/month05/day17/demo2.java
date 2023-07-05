package month05.day17;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 在一个 n * m 的二维数组中，每一行都按照从左到右 非递减 的顺序排序，每一列都按照从上到下 非递减 的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/5/17 17:04
 */
public class demo2 {
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
//        左下角的值,因为左下角的值比较特殊，为该行的最小值以及该列的最大值
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j <= matrix[0].length - 1) {
            if (matrix[i][j] > target) {
//                该行的最小值都大于target，所以该行整体都大于，即删掉该行
                i--;
            } else if (matrix[i][j] < target) {
//                该列的最大值都小于target，所以该列整体都小于，即删除该列
                j++;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
//        判断特殊值的原因是可能传进来一个空的，但是即使是空的，行数也为1，所以上个方法不用判断特殊值.而该方法需要判断列数，但是列数可能为0，所以需要判断
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
//        右上角的值，因为从右上角开始看，这个矩阵就是二叉搜索树
        int i = 0, j = matrix[0].length - 1;
        while (i <= matrix.length - 1 && j >= 0) {
            if (matrix[i][j] > target) {
//                向左子树继续查询
                j--;
            } else if (matrix[i][j] < target) {
//                向右子树查询
                i++;
            } else {
//                找到
                return true;
            }
        }
        return false;
    }
}

