package day41;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * https://leetcode.cn/problems/zigzag-conversion/
 * @date 2023/5/12 12:50
 */
public class demo2 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
//        一共多少行则有多少个stringbuilder，放入list中方便后续通过下标取
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
//       i代表list中的stringbuilder的下标 flag代表方向
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            list.get(i).append(c);
//            到两头时需要换方向
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i = i + flag;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder stringBuilder : list) {
            result.append(stringBuilder);
        }
        return result.toString();
    }
}

