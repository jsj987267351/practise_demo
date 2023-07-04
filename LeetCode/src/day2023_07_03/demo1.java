package day2023_07_03;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * <p>
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
 * <p>
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/ones-and-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/3 20:47
 */
public class demo1 {
    public int findMaxForm(String[] strs, int m, int n) {
//        01背包：装满容量为m个0和n个1的背包最多能装多少物品
//        dp[i][j]含义，装满容量为i个0和j个1的背包最多能装多少物品
//        初始为0，因为容量都为0时一个也装不了
        int[][] dp = new int[m + 1][n + 1];

//        先遍历物品
        for (String str : strs) {
//            取出物品中的0和1的个数
            int zero = 0, one = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
//            倒序遍历背包,两层for循环可以颠倒
            for (int i = m; i >= zero; i--) {
                for (int j = n; j >= one; j--) {
//                    这里将背包容量减去该字符串的重量，然后加上该字符串的价值，也就是1，因为加了1个字符串
                    dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                }
            }
        }
        return dp[m][n];
    }
}

