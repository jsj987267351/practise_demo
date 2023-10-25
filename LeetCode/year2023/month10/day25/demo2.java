package month10.day25;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/25 16:20
 */
public class demo2 {
    List<String> res;
    String[] strings;

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits.length() == 0){
            return res;
        }
        strings = new String[10];
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
        StringBuilder sb = new StringBuilder();
        backtracking(digits, 0, sb);
        return res;
    }

    public void backtracking(String digits, int startIndex, StringBuilder sb) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        int num = digits.charAt(startIndex) - '0';
        String string = strings[num];
        for (int i = 0; i < string.length(); i++) {
            sb.append(string.charAt(i));
            backtracking(digits, startIndex + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

