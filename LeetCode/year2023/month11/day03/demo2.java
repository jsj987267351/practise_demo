package month11.day03;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/3 12:11
 */
public class demo2 {
    List<List<Integer>> res;

    public List<List<Integer>> generate(int numRows) {
        res = new ArrayList<>();
        int[] nums = new int[numRows];
        for (int i = 0; i < numRows; i++) {
            help(nums, i);
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                list.add(nums[j]);
            }
            res.add(list);
        }
        return res;
    }

    public void help(int[] nums, int row) {
        if (row == 0) {
            nums[0] = 1;
            return;
        }
        for (int i = row; i > 0; i--) {
            nums[i] += nums[i - 1];
        }
    }
}

