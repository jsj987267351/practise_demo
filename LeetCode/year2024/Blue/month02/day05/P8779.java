package Blue.month02.day05;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://www.bilibili.com/video/BV1vr4y1i76y/?spm_id_from=333.337.search-card.all.click&vd_source=943ca493b937adf4b7a5aae3a4f3f14f
 * @date 2024/2/5 14:53
 */
public class P8779 {
    private static int[] father;
    private static long[] dis;

    public static void main(String[] args) {
//      想象成坐标轴，0为根节点
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int Q = scanner.nextInt();
        father = new int[N + 1];
        dis = new long[N + 1];
        for (int i = 0; i <= N; i++) {
            father[i] = i;
        }
        for (int i = 0; i < M; i++) {
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            long value = scanner.nextLong();
            int fatherLeft = findFather(left - 1);
            int fatherRight = findFather(right);
            father[fatherLeft] = fatherRight;
            dis[fatherLeft] = dis[right] - dis[left - 1] - value;
        }
        for (int i = 0; i < Q; i++) {
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            int fatherLeft = findFather(left - 1);
            int fatherRight = findFather(right);
            if (fatherLeft != fatherRight){
                System.out.println("UNKNOWN");
            }else {
                System.out.println(dis[right] - dis[left -1]);
            }
        }
        scanner.close();
    }

    public static int findFather(int cur) {
        if (father[cur] != cur) {
            int fa = father[cur];
            father[cur] = findFather(fa);
            dis[cur] += dis[fa];
        }
        return father[cur];
    }
}

