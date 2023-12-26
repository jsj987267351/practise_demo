package month12.day26;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/26 13:04
 */
public class demo4 {
    public int[] missingTwo(int[] nums) {
        int len = nums.length + 2;
        int totalSum = len * (1 + len) / 2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = totalSum - sum;
        int mid = diff / 2;
        int leftSum = mid * (1 + mid) / 2;
        int sum2 = 0;
        for (int num : nums) {
            if (num <= mid) {
                sum2 += num;
            }
        }
        int res1 = leftSum - sum2;
        int res2 = diff - res1;
        return new int[]{res1, res2};
    }
}

