package LeetCode.month07.day05;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/5 9:39
 */
public class demo3 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int curLen = 0, start = 0;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            curLen += words[i].length();
            if (curLen > maxWidth) {
                res.add(toString(words, start, i - 1, maxWidth));
                curLen = words[i].length();
                start = i;
            }
            curLen++;
        }
        res.add(toString(words, start, words.length - 1, maxWidth));
        return res;
    }


    public String toString(String[] words, int start, int end, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        if (start == end) {
            return toStringFirst(words, start, end, maxWidth, sb);
        } else if (end == words.length - 1) {
            return toStringLast(words, start, end, maxWidth, sb);
        } else {
            return toStringCommon(words, start, end, maxWidth, sb);
        }
    }

    public String toStringCommon(String[] words, int start, int end, int maxWidth, StringBuilder sb) {
        int len = 0;
        for (int i = start; i <= end; i++) {
            len += words[i].length();
        }
        int remind = maxWidth - len;
        int spaceAverage = remind / (end - start);
        int spaceRemind = remind % (end - start);
        for (int i = start; i < end; i++) {
            sb.append(words[i]);
            for (int j = 0; j < spaceAverage; j++) {
                sb.append(' ');
            }
            if (spaceRemind > 0) {
                sb.append(' ');
                spaceRemind--;
            }
        }
        sb.append(words[end]);
        return sb.toString();
    }


    public String toStringLast(String[] words, int start, int end, int maxWidth, StringBuilder sb) {
        for (int i = start; i < end; i++) {
            sb.append(words[i]).append(' ');
        }
        sb.append(words[end]);
        int remindSpace = maxWidth - sb.length();
        for (int i = 0; i < remindSpace; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }

    public String toStringFirst(String[] words, int start, int end, int maxWidth, StringBuilder sb) {
        sb.append(words[start]);
        int remindSpace = maxWidth - words[start].length();
        for (int i = 0; i < remindSpace; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }
}

