package Blue.month01.day28;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/28 14:31
 */
public class P8623 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int w = scanner.nextInt();
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[] one = search(w, m);
        int[] two = search(w, n);
        int res = Math.abs(one[0] - two[0]) + Math.abs(one[1] - two[1]);
        System.out.println(res);
        scanner.close();
    }

    //    计算在宽度为len时，num的下标为多少，返回值是长度为2的数组，其中第一个代表x，第一个代表y
    public static int[] search(int len, int num) {
        int[] res = new int[2];
        int row = num % len == 0 ? num / len : (num / len) + 1;
        int col = 0;
        if (row % 2 == 0) {
//            偶数行，倒序
//            当前行最大值
            int curMax = row * len;
            col = curMax - num;
        } else {
//            奇数行，正序
//            当前行最小值
            int curMin = (row -1) * len +1;
            col = num - curMin;
        }
        res[0] = row;
        res[1] = col;
        return res;
    }
}

