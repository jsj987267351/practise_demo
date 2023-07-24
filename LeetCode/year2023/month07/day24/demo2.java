package month07.day24;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * https://leetcode.cn/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 * @date 2023/7/24 13:46
 */
public class demo2 {
    public String minNumber(int[] nums) {
        int length = nums.length;
        String[] strings = new String[length];
        for (int i = 0; i < length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }

//        让两个字符串按照相加比较小的方式升序
        Arrays.sort(strings, (x, y) ->
                (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for (String string : strings) {
            res.append(string);
        }
        return res.toString();
    }
}

