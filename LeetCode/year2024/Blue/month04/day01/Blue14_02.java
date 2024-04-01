package Blue.month04.day01;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/4/1 14:43
 */
public class Blue14_02 {
    private static int res = 0;
    private static int[][] arr;

    public static void main(String[] args) {
        arr = new int[5][5];
        arr[0][0] = 1;
        arr[0][1] = 0;
        arr[0][2] = 1;
        arr[0][3] = 0;
        arr[0][4] = 1;
//        第0行数据是确定的，所以从第一行第0列开始更新数据
        DFS(1, 0);
        System.out.println(res);
    }

    public static void DFS(int row, int col) {
//        如果已经超出行数阈值，说明前面已经更新完了，查看结果是否符合即可
        if (row == 5) {
//            判断第4行唯一的一个数据即可
            if (arr[4][0] == 1) {
                res++;
            }
            return;
        }
//        回溯，因为是三种符合，所以使用三个循环
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                arr[row][col] = arr[row - 1][col] & arr[row - 1][col + 1];
            } else if (i == 1) {
                arr[row][col] = arr[row - 1][col] | arr[row - 1][col + 1];
            } else {
                arr[row][col] = arr[row - 1][col] ^ arr[row - 1][col + 1];
            }
//            开始回溯，如果已经更新完了当前行的最后一个数据，则换行从头更新，否则更新当前行的下一个数据
            if (col == 4 - row) {
                DFS(row + 1, 0);
            } else {
                DFS(row, col + 1);
            }
        }
    }
}

