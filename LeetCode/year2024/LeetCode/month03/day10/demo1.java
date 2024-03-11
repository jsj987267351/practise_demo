package LeetCode.month03.day10;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/3/10 18:33
 */
public class demo1 {
    public int minimumPossibleSum(int n, int target) {
//   看灵神的数学分析
        long mid = Math.min(n, target / 2);
        return (int) ((mid * (1 + mid) + (n - mid - 1 + 2 * target) * (n - mid)) / 2 % 1_000_000_007);
    }
}

