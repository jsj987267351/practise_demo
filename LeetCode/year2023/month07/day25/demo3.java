package month07.day25;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/?envType=study-plan-v2&envId=coding-interviews
 * @date 2023/7/25 13:28
 */
public class demo3 {
    public int lengthOfLongestSubstring(String s) {
//        滑动窗口
        int length = s.length();
        int max = 0;
//        记录滑动窗口的左边界
        int left = 0;
//        map用来存储元素以及对应的下标
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
//            如果遇到重复元素了，窗口就要右移一位，将重复元素从窗口种去掉
            if (map.containsKey(s.charAt(i))) {
//                这里取max是因为left不能往回走，以前的都是已经弹出窗口之外的
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
//            将当前的重复元素的更远距离放入
            map.put(s.charAt(i), i);
//            每次都更新窗口的最大值
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}

