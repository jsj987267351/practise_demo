package month07.day18;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/18 12:41
 */
public class demo2 {
    public int movingCount(int m, int n, int k) {
        boolean[][] used = new boolean[m][n];
        return backtracking(used, k, 0, 0, m, n);
    }

    public int backtracking(boolean[][] used, int k, int row, int col, int m, int n) {
//        这里可以直接计算 row % 10 + row / 10 + col % 10 + col / 10 是因为题目给了范围 m和n<=100所以m-1 和n-1都是最大为两位数
        if (row < 0 || col < 0 || row >= m || col >= n || used[row][col] || row % 10 + row / 10 + col % 10 + col / 10 > k) {
            return 0;
        }
//        回溯，代表该地方到达过了
        used[row][col] = true;
//        返回结果为到达当前地方+1 然后加上上下左右可到达的数量
        return backtracking(used, k, row - 1, col, m, n) + backtracking(used, k, row, col + 1, m, n)
                + backtracking(used, k, row + 1, col, m, n) + backtracking(used, k, row, col - 1, m, n) + 1;
    }
}

