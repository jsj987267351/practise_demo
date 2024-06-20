package LeetCode.month06.day20;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/20 17:32
 */
public class demo11 {
    public int countBeautifulPairs(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int pre = pre(nums[i]);
            for (int j = i + 1; j < nums.length; j++) {
                int aft = nums[j] % 10;
                if (gcd(pre, aft) == 1) {
                    res++;
                }
            }
        }
        return res;
    }

    public int pre(int num) {
        while (num >= 10) {
            num /= 10;
        }
        return num;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}

