package LeetCode.month05.day20;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/5/20 11:31
 */
public class demo1 {
    public int maxDivScore(int[] nums, int[] divisors) {
        int max = -1, res = 0;
        for (int i = 0; i < divisors.length; i++) {
            int temp = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] % divisors[i] == 0) {
                    temp++;
                }
            }
            if (temp > max) {
                res = divisors[i];
                max = temp;
            }else if (temp == max){
                res = Math.min(res,divisors[i]);
            }
        }
        return res;
    }
}

