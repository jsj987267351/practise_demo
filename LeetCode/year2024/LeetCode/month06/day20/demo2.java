package LeetCode.month06.day20;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/20 9:45
 */
public class demo2 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        int left = 0, right = 0, len = s.length(), res = 0;
        while (right < len) {
            if (map.containsKey(charArray[right])) {
                left = Math.max(left, map.get(charArray[right]) + 1);
            }
            map.put(charArray[right], right);
            right++;
            res = Math.max(res, right - left);
        }
        return res;
    }

    public int lengthOfLongestSubstring1(String s) {
        Set<Character> set = new HashSet<>();
        char[] charArray = s.toCharArray();
        int left = 0, right = 0, len = s.length(), res = 0;
        while (right < len) {
            if (set.contains(charArray[right])) {
                while (left < right && charArray[left] != charArray[right]) {
                    set.remove(charArray[left]);
                    left++;
                }
                set.remove(charArray[left]);
                left++;
            }
            set.add(charArray[right]);
            right++;
            res = Math.max(res, set.size());
        }
        return res;
    }
}

