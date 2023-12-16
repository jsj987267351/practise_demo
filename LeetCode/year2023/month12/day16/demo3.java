package month12.day16;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/16 17:41
 */
public class demo3 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int start = 0, length = 0;
        for (int i = 0; i < words.length; i++) {
            length += words[i].length();
            if (length > maxWidth) {
                res.add(help(words, start, i - 1, maxWidth));
                start = i;
                length = words[i].length();
            }
            length++;
        }
        res.add(help(words, start, words.length - 1, maxWidth));
        return res;
    }


    private String help(String[] words, int start, int end, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        if (start == end) {
            oneRow(words, start, end, maxWidth, sb);
        } else if (end == words.length - 1) {
            lastRow(words, start, end, maxWidth, sb);
        } else {
            normal(words, start, end, maxWidth, sb);
        }
        return sb.toString();
    }

    private void oneRow(String[] words, int start, int end, int maxWidth, StringBuilder sb) {
        sb.append(words[start]);
        int length = maxWidth - words[start].length();
        for (int i = 0; i < length; i++) {
            sb.append(" ");
        }
    }

    private void lastRow(String[] words, int start, int end, int maxWidth, StringBuilder sb) {
        for (int i = start; i <= end; i++) {
            sb.append(words[i]);
            if (i == end) {
                int length = maxWidth - sb.length();
                for (int j = 0; j < length; j++) {
                    sb.append(" ");
                }
            } else {
                sb.append(" ");
            }
        }
    }

    private void normal(String[] words, int start, int end, int maxWidth, StringBuilder sb) {
        int length = 0;
        for (int i = start; i <= end; i++) {
            length += words[i].length();
        }
        int count = end - start;
        int remain = maxWidth - length;
        int average = remain / count;
        int remainSpace = remain % count;
        for (int i = start; i <= end; i++) {
            sb.append(words[i]);
            if (i != end) {
                for (int j = 0; j < average; j++) {
                    sb.append(" ");
                }
            }
            if (remainSpace > 0) {
                sb.append(" ");
                remainSpace--;
            }
        }
    }
}

