package day63;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * <p>
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 * <p>
 * 返回一个表示每个字符串片段的长度的列表。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/partition-labels
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/6/15 13:35
 */
public class demo2 {
    public List<Integer> partitionLabels1(String s) {
        List<Integer> res = new ArrayList<>();
//        用map集合存储每个字符出现在的最远位置
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        int start = 0;
        int index = 0;
        while (start < s.length()) {
//            拿到该元素的最远位置
            index = map.get(s.charAt(start));
//            更新最远位置为该从头到该元素位置中的所有元素中的最远位置
            for (int i = start; i < index; i++) {
                index = Math.max(index, map.get(s.charAt(i)));
            }
            res.add(index - start + 1);
            start = index + 1;
        }
        return res;
    }


    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
//        用map集合存储每个字符出现在的最远位置
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
//            不断更新当前的最远距离
            end = Math.max(end, map.get(s.charAt(i)));
            if (i == end) {
//                如果遍历到的当前位置就是前面所有字母的最远距离，代表该距离可以切一刀，即收入结果
                res.add(end - start + 1);
//                更新开始索引
                start = i + 1;
            }
        }
        return res;
    }
}

