package LeetCode.month06.day20;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/20 11:02
 */
public class demo8 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                if (sb.length() == 0) {
                    sb.append(nums[i]);
                }
            } else if (sb.length() == 0) {
                sb.append(nums[i]);
                res.add(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append("->").append(nums[i]);
                res.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return res;
    }
}

