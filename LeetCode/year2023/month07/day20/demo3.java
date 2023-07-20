package month07.day20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 * <p>
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof/?envType=study-plan-v2&envId=coding-interviews
 * @date 2023/7/20 14:50
 */
public class demo3 {
    public String[] permutation(String s) {
//      回溯
        List<String> res = new ArrayList<>();

        int length = s.length();
        char[] chars = s.toCharArray();

        boolean[] used = new boolean[length];
        StringBuilder sb = new StringBuilder();
        Arrays.sort(chars);
        backtracking(res, chars, used, sb);

        return res.toArray(new String[res.size()]);
    }

    public void backtracking(List<String> res, char[] chars, boolean[] used, StringBuilder sb) {
        if (sb.length() == chars.length) {
            res.add(sb.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (used[i]) continue;
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) continue;

            sb.append(chars[i]);
            used[i] = true;
            backtracking(res, chars, used, sb);
            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }
}

