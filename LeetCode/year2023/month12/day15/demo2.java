package month12.day15;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/15 14:53
 */
public class demo2 {
    public int singleNumber(int[] nums) {
        int[] ints = new int[32];
        for (int num : nums) {
            for (int i = 31; i >= 0; i--) {
                if ((num & 1) != 0) {
                    ints[i]++;
                }
                num >>= 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            ints[i] %= 3;
            res += (ints[i] <<= (32 - i - 1));
        }
        return res;
    }
}

