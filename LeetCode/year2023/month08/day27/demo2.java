package month08.day27;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 * <p>
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 * <p>
 * 回文串不一定是字典当中的单词。
 * @date 2023/8/27 13:02
 */
public class demo2 {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.size() < 2;
    }
}

