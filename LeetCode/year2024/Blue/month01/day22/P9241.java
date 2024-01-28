package Blue.month01.day22;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/22 13:22
 */
public class P9241 {
    private static int T[];
    private static int D[];
    private static int L[];
    private static boolean Used[];
    private static boolean flag;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        for (int i = 0; i < sum; i++) {
            int Total = scanner.nextInt();
            T = new int[Total];
            D = new int[Total];
            L = new int[Total];
            Used = new boolean[Total];
            for (int j = 0; j < Total; j++) {
                T[j] = scanner.nextInt();
                D[j] = scanner.nextInt();
                L[j] = scanner.nextInt();
            }
            flag = false;
            DFS(0,0,Total);
            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        scanner.close();
    }

    public static void DFS(int flySum,int time,int Total) {
        if (flySum == Total) {
            flag = true;
            return;
        }
        for (int i = 0; i < Total; i++) {
            if (time <= T[i] + D[i] && !Used[i]) {
                Used[i] = true;
                int tempTime = time;
                if (time < T[i]) {
//                    还没到开始飞的时间，直接把时间移动到最早可以飞行到陆地的时间
                    time = T[i] + L[i];
                } else {
//                    当前就可以飞
                    time += L[i];
                }
                DFS(flySum + 1,time,Total);
                time = tempTime;
                Used[i] = false;
            }
        }
    }
}

