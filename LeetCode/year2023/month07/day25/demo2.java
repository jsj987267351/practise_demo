package month07.day25;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/25 12:42
 */
public class demo2 {
    public int translateNum(int num) {
//        动态规划，跟爬楼梯类似
        String s = String.valueOf(num);
        int length = s.length();
//        dp[i]含义：长度为i+1时的不同翻译方法
        int[] dp = new int[length];
//        特判
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return 1;
        }
//        长度为1时方法为1
        dp[0] = 1;
//        长度为2时有两种情况，即是否可以结合翻译，如果可以结合就是2种，否则就是一种
//        之所以要大于等于10，因为01 这种是无法翻译的
        if (Integer.parseInt(s.substring(0, 2)) >= 10 && Integer.parseInt(s.substring(0, 2)) <= 25) {
            dp[1] = 2;
        } else {
            dp[1] = 1;
        }
//        根据状态转移方程遍历计算，如果可以和前面结合翻译的话，就等于单独翻译的总数+结合翻译的总数
//        否则就是单独翻译的总数
//        其中单独翻译的总数与前一位相同，因为就是在前一位的所有方法后加上该数字即可
//        结合翻译的总数与第前二位相同，因为就是在第前二位的所有方法的最后加上结合数即可
        for (int i = 2; i < length; i++) {
            int nums = Integer.parseInt(s.substring(i - 1, i + 1));
            if (nums >= 10 && nums <= 25) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[length - 1];
    }
}

