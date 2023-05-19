package day47;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * <p>
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * <p>
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * <p>
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * 链接：https://leetcode.cn/problems/reverse-words-in-a-string
 * @date 2023/5/19 15:48
 */
public class demo4 {
    public String reverseWords(String s) {
//        开始先在头部加一个空格，防止没有空格导致后续判断不到直接返回
        s = ' ' + s;
        StringBuilder temp = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (int i = s.length()-1; i>=0 ; i--) {
            if (s.charAt(i)==' '){
//                等于空格的话，判断是否已经收集到了值，收集到了的话加入结果，然后重新置空
                if (temp.length()>0){
                    result.append(temp.reverse().toString()).append(" ");
                    temp.delete(0,temp.length());
                }
            }else {
                temp.append(s.charAt(i));
            }
        }
        return result.toString().trim();
    }
}

