package Blue.month03.day11;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/3/11 15:35
 */
public class A3176 {
    public static int N;
    public static int K;
    public static int[] robot;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();
//        记录每个机器人的位置
        robot = new int[K];
        for (int i = 0; i < K; i++) {
            robot[i] = scanner.nextInt();
        }
        Arrays.sort(robot);
        int left = 1, right = N;
//        二分查找每个机器人最少打扫几个格子才能完全打扫完
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(mid)) {
//                如果当前格子能够打扫玩的话，往左继续找，因为要找最小满足步数
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
//        最终left就是每个机器人最少要打扫的格子数目，除去自身本来位置，也就是要打扫left-1个格子，一共要走 （left-1）*2步数
//        因为要来回，最终要回到起点
        System.out.println((left - 1) * 2);
        scanner.close();
    }

    public static boolean check(int num) {
//        记录上一个机器人能打扫到的格子右林边界
        int last = 0;
//        遍历每一个机器人最终能打扫的最远位置
        for (int i = 0; i < K; i++) {
            if (robot[i] - num <= last) {
//                说明当前机器人往左最远能够打扫到上一个机器人的右边最远位置
//                更新右边的最远边界
//                从第一个未打扫的格子往右打扫num个，这里要-1是因为机器人本身所在格子已经打扫过了
//                计算思路为机器人要么在边界右边，要么在左边，在左边的话直接往右打扫num即可
//                在右边的话，需要先把左边剩余的打扫完，才能打扫右边
                last = Math.min(last + 1, robot[i]) + num - 1;
            } else {
//                否则说明当前步数两个机器人之间的格子无法全部打扫，直接返回false
                return false;
            }
        }
//        返回打扫完毕的右边界是否全部打扫完了
        return last >= N;
    }
}

