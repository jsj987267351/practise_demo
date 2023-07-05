package month03.day17;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标
 * https://leetcode.cn/problems/two-sum/
 */
public class demo3 {
    public int[] twoSum1(int[] nums, int target) {
        int question[] = new int[2];

        for (int i = 0; i < nums.length; i++) {

            for (int j = i+1; j < nums.length-1; j++) {
                if(nums[i] + nums[j] == target){
                    question[0] = i;
                    question[1] = j;
                    break;
                }
            }
        }
        return question;
    }

    public int[] twoSum(int[] nums, int target) {
        int question[] = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        map.put(nums[0],0);
        for (int i = 1; i <nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                question[0] = map.get(target - nums[i]);
                question[1] = i;
                break;
            }
            map.put(nums[i] , i);
        }
        return question;
    }
}
