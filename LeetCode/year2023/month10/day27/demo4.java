package month10.day27;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/27 12:29
 */
public class demo4 {
    public int majorityElement(int[] nums) {
        int res = nums[0], count = 1;
        for (int i = 1; i <nums.length ; i++) {
            if (nums[i] == res){
                count++;
            }else if (count == 0){
                res = nums[i];
            }else {
                count--;
            }
        }
        return res;
    }
}

