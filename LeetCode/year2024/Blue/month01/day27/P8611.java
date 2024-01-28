package Blue.month01.day27;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/27 15:36
 */
public class P8611 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
//        left代表感染蚂蚁的左边在行进中不会被感染的蚂蚁数量，right代表感染蚂蚁的右边在行进中不会被感染的蚂蚁数量
        int res = 0, left = 0, right = 0;
        for (int i = 0; i < n; i++) {
//            如果当前蚂蚁在感染蚂蚁的左边，并且往左走，那么一定不会被感染，与移动机器人一样，每个蚂蚁都可以看作相同的个体，穿模数量不变
            if (arr[i] < 0 && Math.abs(arr[i]) < Math.abs(arr[0])) {
                left++;
            }
//            同理在右边往右走不会被感染
            if (arr[i] > 0 && Math.abs(arr[i]) > Math.abs(arr[0])) {
                right++;
            }
        }
        res = n - left - right;
        System.out.println(res);
        scanner.close();
    }
}

