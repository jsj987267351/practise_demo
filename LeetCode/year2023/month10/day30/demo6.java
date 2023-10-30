package month10.day30;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/30 12:54
 */
public class demo6 {
    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length < 2) {
            return strs[0];
        }
//        根据ascii码排序
        Arrays.sort(strs);
        String a = strs[0];
        String b = strs[length - 1];
        StringBuilder res = new StringBuilder();
        int index = 0;
        while (index < a.length() && index < b.length()) {
            if (a.charAt(index) == b.charAt(index)) {
                res.append(a.charAt(index));
                index++;
            } else {
                break;
            }
        }
        return res.toString();
    }
}

