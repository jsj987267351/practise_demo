package day55;

import java.util.*;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/6/2 15:52
 */
public class demo2 {
    public List<Integer> findAnagrams1(String s, String p) {
//        暴力解法，直接挨个符合长度的字符串进行判断
        List<Integer> list = new ArrayList<>();
        int[] ints = new int[26];
        for (int i = 0; i < p.length(); i++) {
            ints[p.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            if (help(s.substring(i, i + p.length()), ints)) {
                list.add(i);
            }
        }
        return list;
    }

    public boolean help(String s, int[] ints) {
        int[] temp = new int[26];
        for (int i = 0; i < s.length(); i++) {
            temp[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (temp[i] != ints[i]) return false;
        }
        return true;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int lengths = s.length();
        int lengthp = p.length();
        if (lengths < lengthp) {
            return list;
        }
//        滑动窗口
        int[] ints = new int[26];
        int[] intp = new int[26];
//        首先判断从0开始的是否匹配
        for (int i = 0; i < lengthp; i++) {
            ints[s.charAt(i) - 'a']++;
            intp[p.charAt(i) - 'a']++;
        }
//        如果是异位词，直接加入起始位置
        if (Arrays.equals(ints, intp)) {
            list.add(0);
        }
//        开始滑动
        for (int i = 0; i < lengths - lengthp; i++) {
//            将头去掉
            ints[s.charAt(i) - 'a']--;
//            加入尾部
            ints[s.charAt(i + lengthp) - 'a']++;
//            在判断
            if (Arrays.equals(ints, intp)) {
                list.add(i + 1);
            }
        }
        return list;
    }

    public List<Integer> findAnagrams(String s, String p) {
//        滑动窗口
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
//        首先记录p所有字符串出现的次数
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
//        窗口的左右，左闭右开，valid代表已经符合了多少字符,当valid等于need.size时代表找到一个符合的
        int left = 0, right = 0, valid = 0;
        List<Integer> result = new ArrayList<>();
        while (right < s.length()) {
//            拿出右边字符
            char c = s.charAt(right);
            right++;
//            如果该字符在need中存在的话，说明找到了一个字符，可以在窗口window对应字符数量++
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
//                如果该字符数量已经相等，即可valid++；
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
//                滑动窗口，
                while (right - left >= p.length()) {
//                    如果valid等于need.size，代表找到符合的字符串
                    if (valid == need.size()) {
                        result.add(left);
                    }
                    char d = s.charAt(left);
                    left++;
//                    判断去除的左边界是否属于need中的字符
                    if (need.containsKey(d)) {
//                        如果当前字符是满足的，那么因为去掉了该字符，所以valid也要--
                        if (window.get(d).equals(need.get(d))) {
                            valid--;
                        }
//                        当前字符的数量在window中--
                        window.put(d, window.get(d) - 1);
                    }
                }

        }
        return result;
    }

}
























