package month11.day24;

import java.util.Collections;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/24 12:53
 */
public class demo1 {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int left = 0, right = nums.size()-1 ,res = 0;
        while (left < right){
            if (nums.get(left) + nums.get(right) < target){
                res+=right - left;
                left++;
            }else {
                right--;
            }
        }
        return res;
    }
}

