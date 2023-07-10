package month07.day10;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数。
 *
 * 题目数据保证答案符合 32 位带符号整数范围。
 * https://leetcode.cn/problems/distinct-subsequences/
 * @date 2023/7/10 16:37
 */
public class demo1 {
    public int numDistinct(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        int lengths = chars.length;
        int lengtht = chart.length;

//        dp[i][j]含义为 以i-1和以j-1结尾的两个字符串中出现的次数
        int[][] dp = new int[lengths + 1][lengtht + 1];

//        首先当字符串t为空时，那么出现的次数皆为1
        for (int i = 0; i <= lengths; i++) {
            dp[i][0] = 1;
        }
//        当字符串s为空且t不为空时，也要初始化为0.这样就初始化好了第一行和第一列，其余可以靠推导得出

//        遍历顺序，从左到右，从上到下。根据推导公式得来
//        之所以从1开始遍历，是因为第一行和第一列已经初始化好了
        for (int i = 1; i <= lengths; i++) {
            for (int j = 1; j <= lengtht; j++) {
//                如果前面的字符相等，那么就可以两个都往前一位继续比较，也可以只让s往前一位进行比较，即让s往前一位继续与t当前位进行比较
//                因为有可能删除s当前字符后仍然相等可以比较
                if (chars[i - 1] == chart[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
//                    不相等的话，只需要让s往前一位即可。因为当前位置已经不相等了，所以即使都往前一位也没意义
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[lengths][lengtht];
    }
}

