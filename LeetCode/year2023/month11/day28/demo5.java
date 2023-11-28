package month11.day28;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/28 14:43
 */
public class demo5 {
    List<String> res;

    public List<String> summaryRanges(int[] nums) {
        res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i + 1 < length && nums[i] == nums[i + 1] - 1) {
                if (sb.length() == 0) {
                    sb.append(nums[i]);
                }
            } else {
                if (sb.length() == 0) {
                    res.add(String.valueOf(nums[i]));
                } else {
                    sb.append("->").append(nums[i]);
                    res.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
        }
        return res;
    }
}

