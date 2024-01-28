package LeetCode.month01.day20;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/20 21:55
 */
public class demo {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            int length = word.length();
            int start = 0, end = 0;
            while (end < length) {
                if (word.charAt(end) == separator) {
                    if (end > start) {
//                        中间要有字符，不能只是一个分隔符
                        res.add(word.substring(start, end));
                    }
                    start = end + 1;
                } else if (end == length - 1) {
                    res.add(word.substring(start, length));
                }
                end++;
            }
        }
        return res;
    }
}

