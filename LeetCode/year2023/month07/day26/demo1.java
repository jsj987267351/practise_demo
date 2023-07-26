package month07.day26;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * <p>
 *  
 * <p>
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/nge-tou-zi-de-dian-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/26 13:21
 */
public class demo1 {
    public double[] dicesProbability(int n) {
//        初始化数组，初始化n=1时的数组，1-6的每个数字出线的概率都是1/6
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
//        开始动态规划，每次都由前一次少一个筛子的情况推出，最终求出n个筛子的结果
        for (int i = 2; i <= n; i++) {
//            每次都要创建新数组，因为筛子数量不同，结果的数量也不同
//            结果的数量等于6*x - (x-1) 这里x为筛子的数量  化简即为5*x+1
            double[] temp = new double[5 * i + 1];
//            通过遍历前一个筛子的情况
            for (int j = 0; j < dp.length; j++) {
//                这里k遍历6次代表当前筛子投出1-6的可能
                for (int k = 0; k < 6; k++) {
//                前一个筛子投出和为j的情况概率加上当前筛子投出的情况即为j+k
//                这里解释为当前投出数量为j+k的筛子的概率为 当前投出1-6的概率是1/6，然后相乘j+k-k的概率在累加
                    temp[j + k] += dp[j] * (1.0 / 6.0);
                }
            }
            dp = temp;
        }
        return dp;
    }
}

