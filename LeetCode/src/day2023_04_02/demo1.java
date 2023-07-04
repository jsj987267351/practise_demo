package day2023_04_02;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * @date 2023/4/2 20:04
 * https://leetcode.cn/problems/length-of-last-word/
 */
public class demo1 {
    public int lengthOfLastWord(String s) {
        s =  s.trim();
        if (!s.contains(" ")){
            return s.length();
        }
        String substring = s.substring(s.lastIndexOf(" "));
        return substring.length()-1;
    }
}

