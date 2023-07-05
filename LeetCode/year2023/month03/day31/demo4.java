package month03.day31;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢
 * @date 2023/3/31 15:16
 * https://leetcode.cn/problems/climbing-stairs/
 */
public class demo4 {
    public int climbStairs(int n) {
        int[] ints = new int[46];
        ints[1] = 1;
        ints[2] = 2;
        for (int i = 3; i <ints.length ; i++) {
            ints[i] = ints[i-1] + ints[i-2];
        }
        return ints[n];
    }
}

