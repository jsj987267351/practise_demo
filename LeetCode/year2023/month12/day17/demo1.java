package month12.day17;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/17 19:18
 */
public class demo1 {
    public int[] singleNumber(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        int different = 1;
        while (true) {
            if ((sum & different) != 0) {
                break;
            }
            different <<= 1;
        }
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & different) != 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}

