package month11.day06;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/5 16:42
 */
public class demo3 {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        res[0] = 1;
        for (int i = 1; i < length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            res[i] = res[i] * R;
            R = R * nums[i];
        }
        return res;
    }

    public int[] productExceptSelf1(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        int[] right = new int[length];
        int[] res = new int[length];
        left[0] = 1;
        right[length - 1] = 1;
        for (int i = 1; i < length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int i = length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}

