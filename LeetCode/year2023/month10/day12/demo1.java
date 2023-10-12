package month10.day12;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/12 12:01
 */
public class demo1 {
    public long findTheArrayConcVal(int[] nums) {
        long res = 0;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (left < right) {
                res += Integer.valueOf(String.valueOf(nums[left++]) + String.valueOf(nums[right--]));
            } else {
                res += Integer.valueOf(String.valueOf(nums[left++]));
            }
        }
        return res;
    }
}

