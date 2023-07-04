package day2023_06_03;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 * https://leetcode.cn/problems/permutation-i-lcci/
 * @date 2023/6/3 21:17
 */
public class demo2 {
    public String[] permutation(String S) {
        char[] chars = S.toCharArray();
        boolean[] used = new boolean[chars.length];
        List<String> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        backtracking(chars, used, list, stringBuilder, chars.length);
        return list.toArray(new String[list.size()]);

    }

    public void backtracking(char[] chars, boolean[] used, List<String> list, StringBuilder stringBuilder, int length) {
        if (stringBuilder.length() == length) {
            list.add(stringBuilder.toString());
            return;
        }

        for (int i = 0; i < length; i++) {
            if (used[i]) continue;
            stringBuilder.append(chars[i]);
            used[i] = true;
            backtracking(chars, used, list, stringBuilder, length);
            used[i] = false;
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}

