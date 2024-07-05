package LeetCode.month07.day05;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/5 10:31
 */
public class demo7 {
    public int[] missingTwo(int[] nums) {
        int len = nums.length + 2;
        int totalSum = len * (1 + len) / 2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = totalSum - sum;
        int mid = diff / 2;
        int leftSum = 0;
        for (int num : nums) {
            if (num <= mid) {
                leftSum += num;
            }
        }
        int sumLeftTotal = mid * (1 + mid) / 2;
        int resLeft = sumLeftTotal - leftSum;
        int resRight = diff - resLeft;
        return new int[]{resLeft, resRight};
    }
}

