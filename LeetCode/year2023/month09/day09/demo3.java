package month09.day09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/9/9 14:03
 */
public class demo3 {
    public String[] permutation(String S) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char[] chars = S.toCharArray();
        Arrays.sort(chars);
        boolean[] used = new boolean[chars.length];
        backtracking(res, sb, chars, used, chars.length);
        return res.toArray(new String[res.size()]);
    }

    private void backtracking(List<String> res, StringBuilder sb, char[] chars, boolean[] used, int length) {
        if (sb.length() == length) {
            res.add(sb.toString());
            return;
        }

        for (int i = 0; i < length; i++) {
            if (i > 0 && !used[i - 1] && chars[i] == chars[i - 1] || used[i]) continue;
            sb.append(chars[i]);
            used[i] = true;
            backtracking(res, sb, chars, used, length);
            used[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

