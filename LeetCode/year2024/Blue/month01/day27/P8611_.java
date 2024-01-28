package Blue.month01.day27;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/27 15:54
 */
public class P8611_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
//        left代表感染蚂蚁左边朝着母体走的蚂蚁数量，right代表右边
        int res = 0, left = 0, right = 0;
        for (int i = 0; i < n; i++) {
//            如果朝着感染蚂蚁走，默认感染蚂蚁另一方向还有蚂蚁，代表感染蚂蚁一定会回头，所以朝着母体走的一定会被感染
            if (arr[i] < 0 && Math.abs(arr[i]) > Math.abs(arr[0])) {
                right++;
            }

            if (arr[i] > 0 && Math.abs(arr[i]) < Math.abs(arr[0])) {
                left++;
            }
        }
//        如果感染蚂蚁朝右走，并且右边没有朝左走的蚂蚁，或者朝左走并且左边没有朝右走的蚂蚁，那么就不会有额外的蚂蚁被感染
        if (arr[0] > 0 && right == 0 || arr[0] < 0 && left == 0) {
            res = 1;
        } else {
            res = left + right + 1;
        }
        System.out.println(res);
        scanner.close();
    }
}

