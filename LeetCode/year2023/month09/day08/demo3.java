package month09.day08;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/9/8 15:19
 */
public class demo3 {
    public int findMagicIndex(int[] nums) {
//         暴力解法
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                return i;
            }
        }
        return -1;
    }
}

