package month10.day20;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/zigzag-conversion/?envType=list&envId=hliQiQFH
 * @date 2023/10/20 15:48
 */
public class demo4 {
    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int index = 0, flag = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            list.get(index).append(c);
            if (index == numRows - 1 || index == 0) {
                flag = -flag;
            }
            index += flag;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            res.append(list.get(i));
        }
        return res.toString();
    }
}

