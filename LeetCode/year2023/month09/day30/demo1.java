package month09.day30;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/missing-two-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/9/30 16:23
 */
public class demo1 {
    public int[] missingTwo(int[] nums) {
        int len = nums.length + 2;
//        等差数列求和公式求出不缺值时的总和
        int totalSum = len * (1 + len) / 2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
//        缺失的两个数字的和
        int diff = totalSum - sum;
//        因为缺失的两个数字一定不同，所以一定一个比mid大，一个小于等于mid
        int mid = diff / 2;
//        求出1到mid的理论总和与数组中的实际总和，差值即为缺失的那个比mid小的值
        int sum2 = 0;
        for (int num : nums) {
            if (num <= mid) {
                sum2 += num;
            }
        }
//        计算1到mid的实际总和
        int sumLeftTotal = mid * (1 + mid) / 2;
//        二者差值即为一个最终答案
        int res = sumLeftTotal - sum2;
//        另一个答案即可通过二者总和求出
        return new int[]{res, diff - res};
    }

}

