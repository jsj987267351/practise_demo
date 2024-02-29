package Blue.month02.day29;

import java.util.*;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/2/29 14:23
 */
public class A1238 {
    public static int len = 10010;
    public static int Good[] = new int[len];
    public static boolean isHot[] = new boolean[len];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int D = scanner.nextInt();
        int K = scanner.nextInt();
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            int time = scanner.nextInt();
            int id = scanner.nextInt();
            arr[i][0] = time;
            arr[i][1] = id;
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        for (int end = 0, start = 0; end < N; end++) {
            int time = arr[end][0];
            int id = arr[end][1];
            Good[id]++;
            while (time - arr[start][0] >= D) {
                Good[arr[start][1]]--;
                start++;
            }
            if (Good[id] >= K) {
                isHot[id] = true;
            }
        }
        for (int i = 0; i < len; i++) {
            if (isHot[i]) System.out.println(i);
        }
        scanner.close();
    }
}

