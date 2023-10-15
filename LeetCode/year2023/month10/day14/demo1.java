package month10.day14;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/14 11:15
 */
public class demo1 {
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}

