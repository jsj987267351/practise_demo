package month11.day12;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/12 14:30
 */
public class demo2 {
    public int maxProduct(int[] nums) {
//        每次遍历到当前数字时，判断以当前数字为连续数组的末尾的最大值与最小值，
        int res = Integer.MIN_VALUE, preMax = 1, preMin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = preMax;
                preMax = preMin;
                preMin = temp;
            }
            preMax = Math.max(preMax * nums[i], nums[i]);
            preMin = Math.min(preMin * nums[i], nums[i]);
            res = Math.max(res, preMax);
        }
        return res;
    }
}

