package month05.day08;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 链接：https://leetcode.cn/problems/letter-combinations-of-a-phone-number
 * @date 2023/5/8 18:16
 */
public class demo5 {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length()==0){
            return result;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String[] strings = new String[10];
        strings[0] = "";
        strings[1] = "";
        strings[2] = "abc";
        strings[3] = "def";
        strings[4] = "ghi";
        strings[5] = "jkl";
        strings[6] = "mno";
        strings[7] = "pqrs";
        strings[8] = "tuv";
        strings[9] = "wxyz";
        backtracking(result, strings, stringBuilder, digits, 0);

        return result;
    }

    public void backtracking(List<String> result, String[] strings, StringBuilder stringBuilder, String digits, int index) {

        if (index == digits.length()) {
            result.add(stringBuilder.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';

        String string = strings[digit];

        for (int i = 0; i < string.length(); i++) {
            stringBuilder.append(string.charAt(i));
            backtracking(result,strings,stringBuilder,digits,index+1);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }
}

