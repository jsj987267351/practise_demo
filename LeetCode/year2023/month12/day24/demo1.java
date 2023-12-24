package month12.day24;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/24 17:06
 */
public class demo1 {
    public int majorityElement(int[] nums) {
        int length = nums.length;
        int res = nums[0];
        int count = 1;
        for (int i = 1; i < length; i++) {
            if (nums[i] == res) {
                count++;
            } else if (count == 0) {
                res = nums[i];
                count = 1;
            } else {
                count--;
            }
        }
        count = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == res) {
                count++;
            }
        }
        return count <= length / 2 ? -1 : res;
    }
}

