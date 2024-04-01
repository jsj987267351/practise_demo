package Blue.month04.day01;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/4/1 12:48
 */
public class P8787 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        每根竹子最多砍10次就会到1，所以arr[i][j]记录第i跟竹子砍倒数第j次时的高度，即arr[i][0]记录竹子i砍到满足需求前的最后一刀的高度
        long[][] arr = new long[n][10];
//        用来临时存储每根竹子每刀后的长度
        long[] temp = new long[10];
//        统计一共砍多少刀
        long res = 0;
        for (int i = 0; i < n; i++) {
//            当前竹子的初始高度
            long height = scanner.nextLong();
//            当前竹子的被砍刀数
            int countCut = 0;
//            被砍第0刀时的高度就是初始高度
            temp[countCut] = height;
//            一直循环，直到高度小于1
            while (height > 1) {
                countCut++;
                height = sqrt(height / 2 + 1);
//                记录当前刀剩余的高度
                temp[countCut] = height;
            }
//            将当前竹子每一刀的变化记录到二维数组上，采用逆序记录,此时的第count刀是已经满足要求的刀数了，所以从count-1开始记录
            for (int j = 0, k = countCut -1; k >= 0; k--, j++) {
                arr[i][j] = temp[k];
            }
//            统计一共砍了多少刀到总数上，此时res记录的是对每根竹子单独砍到要求总共需要多少刀
            res += countCut;
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 1; j < n; j++) {
//                如果相邻竹子在同一刀砍之前高度一直，则可以少砍一刀
                if (arr[j][i] > 0 && arr[j][i] == arr[j - 1][i]) {
                    res--;
                }
            }
        }
        scanner.close();
    }

    //    计算，因为math的sqrt不支持long类型
    public static long sqrt(long num) {
        long res = 0;
        long left = 0L, right = (long) 1e9, mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (mid * mid <= num) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}

