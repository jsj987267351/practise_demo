package month09.day25;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/find-longest-subarray-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/9/25 15:49
 */
public class demo1 {
    public String[] findLongestSubarray(String[] array) {
//        前缀和 key为前缀和，value为此前缀和第一次出现的下标,将字母看作1 数字看作-1.此前缀和包括本身
        Map<Integer, Integer> map = new HashMap<>();
//        起始头位置总和为0，即左开有闭
        map.put(0,-1);
//        注意题目。如果当前字符串不止一个字母，则按照该字符串的第一个字母来判定是数字还是字母
//        sum代表前缀和，start代表最长子数组的起始下标 ,max代表最长子数组的长度
        int sum = 0, start = 0, max = 0;
        for (int i = 0; i < array.length; i++) {
//            判断是字母还是数字
            sum += array[i].charAt(0) >= 'A' ? 1 : -1;
//            判断前面是否出现过该前缀和
            if (map.containsKey(sum)) {
//                该前缀和首次出现的索引
                int firstIndex = map.get(sum);
//                判断该子数组是否为最大
                if (i - firstIndex > max) {
                    max = i - firstIndex;
                    start = firstIndex;
                }
            } else {
//                没出现的话就要将其压入map集合中
                map.put(sum, i);
            }
        }
        String[] res = new String[max];
//        此时的start即为最长子数组的索引，max为长度
        for (int i = 0; i < res.length; i++) {
//            这里使用start +1 是因为前缀和包括本身，所以如果出现相同的前缀和，那么就是左开右闭的
            res[i] = array[i + start +1];
        }
        return res;
    }
}

