package month04.day06;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * @date 2023/4/6 10:59
 * https://leetcode.cn/problems/ti-huan-kong-ge-lcof/
 */
public class demo2 {
    public String replaceSpace1(String s) {
        String replace = s.replace(" ", "%20");
        return replace;
    }

    public String replaceSpace(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)!=' '){
                result.append(s.charAt(i));
            }else {
                result.append("%20");
            }
        }
        return result.toString();
    }
}

