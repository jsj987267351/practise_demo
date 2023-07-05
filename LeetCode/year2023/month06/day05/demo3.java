package month06.day05;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * https://leetcode.cn/problems/minimum-window-substring/?envType=study-plan-v2&envId=top-100-liked
 * @date 2023/6/5 15:31
 */
public class demo3 {
    public  String minWindow(String s, String t) {
//        存储t中各个字符的数量
        Map<Character, Integer> need = new HashMap<>();
//        存储窗口中各个字符的数量
        Map<Character, Integer> window = new HashMap<>();
//        先给need map集合赋值。存储每个字符出现的次数
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
//        存储满足条件字符的个数
        int valid = 0;
//        窗口的左右边界
        int left = 0, right = 0;
//        最终的起始索引
        int start = 0, len = Integer.MAX_VALUE, end = 0;

        while (right < s.length()) {
//            首先拿出有边界的值，左闭右开，所以需要先存入，在移动
            char c = s.charAt(right);
            right++;
//            查看need是否存在该字符，存在的话窗口中也要添加，不存在的话就没必要添加了
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
//                如果该字符的数量已经达到了满足，那么满足个数+1
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
//            当满足个数一直处于满足状态时
            while (valid == need.size()) {
//                因为求最小覆盖字串，所以只有当当前窗口长度小的时候才进行更新
                if (right - left < len) {
                    start = left;
                    end = right;
                    len = right - left;
                }
//                窗口左边界开始左移，先临时存储要删掉的左边界字符
                char d = s.charAt(left);
                left++;
//                如果该字符need中也有的话，window中该字符的数量就要-1，因为移除了窗口，并且window窗口一定有该元素，因为前面判断过了
                if (need.containsKey(d)) {
//                    如果该字符已经满足的话，那么满足个数也要-1，因为移除该元素后该元素的数量就不满足了
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

//        最后返回,注意substring第二个参数不是长度，而是坐标
        return len == Integer.MAX_VALUE?"":s.substring(start,end);
    }

}

