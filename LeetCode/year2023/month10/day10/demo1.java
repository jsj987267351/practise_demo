package month10.day10;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/10 12:57
 */
public class demo1 {
    final long Mod = (long) 1e9 + 7;

    public int sumDistance(int[] nums, String s, int d) {
//        机器碰撞就转向可以理解为两个机器互相穿模了，即交换两个机器互相走完对方剩余的步数，走完之后互相到达了对方应该到的地方
//        但是剩余的步数是相等的，而且每个机器可以理解为一样的，所以可以理解为穿模,也就是忽略碰撞这一条件
        int len = nums.length;
        long[] a = new long[len];
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'L') {
//                往左走就是负
                a[i] = nums[i] - d;
            } else {
                a[i] = nums[i] + d;
            }
        }
        Arrays.sort(a);
//        后续根据数学法计算，可以查看 灵茶山艾府 题解
//        计算当前点与前面每个点之间的距离，这样遍历到最后求和即可，根据加法结合律可以得出答案
//        结果以及 遍历到当前点的前缀和
        long res = 0, tempSum = 0;
        for (int i = 0; i < len; i++) {
            res = (res + i * a[i] - tempSum) % Mod;
            tempSum += a[i];
        }
        return (int) res;
    }
}

