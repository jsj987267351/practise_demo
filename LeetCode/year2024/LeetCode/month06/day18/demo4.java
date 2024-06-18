package LeetCode.month06.day18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/18 10:16
 */
public class demo4 {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int index = 0, flag = -1;
        for (int i = 0; i < s.length(); i++) {
            list.get(index).append(s.charAt(i));
            if (index == 0  || index == numRows - 1) {
                flag = -flag;
            }
            index += flag;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}

