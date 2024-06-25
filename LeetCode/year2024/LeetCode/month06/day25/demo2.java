package LeetCode.month06.day25;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/25 9:55
 */
public class demo2 {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE, preMax = 1, preMin = 1;
        for (int num : nums) {
            if (num < 0) {
                int temp = preMax;
                preMax = preMin;
                preMin = temp;
            }
            preMax = Math.max(preMax * num, num);
            preMin = Math.min(preMin * num, num);
            res = Math.max(res, preMax);
        }
        return res;
    }
}

