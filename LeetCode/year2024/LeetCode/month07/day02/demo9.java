package LeetCode.month07.day02;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/2 10:56
 */
public class demo9 {
    public int[] singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        int temp = 1;
        while ((res & temp) == 0) {
            temp <<= 1;
        }
        int a = 0,b = 0;
        for (int num : nums) {
            if ((num & temp) == 0){
                a^=num;
            }else {
                b^=num;
            }
        }
        return new int[]{a,b};
    }
}

