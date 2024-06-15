package LeetCode.month06.day15;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/15 14:59
 */
public class demo8 {
    List<String> res = new ArrayList<>();
    StringBuilder sb;

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) return res;
        sb = new StringBuilder(s);
        backtracking(sb, 0, 0);
        return res;
    }

    public void backtracking(StringBuilder sb, int index, int DotNum) {
        if (DotNum == 3) {
            if (isValid(sb, index, sb.length() - 1)) {
                res.add(sb.toString());
            }
            return;
        }
        for (int i = index; i < sb.length(); i++) {
            if (isValid(sb, index, i)) {
                sb.insert(i + 1, '.');
                backtracking(sb, i + 2, DotNum + 1);
                sb.deleteCharAt(i + 1);
            }
        }
    }

    public boolean isValid(StringBuilder sb, int left, int right) {
        if (right - left > 2 || left > right) {
            return false;
        }
        if (sb.charAt(left) == '0' && left != right) {
            return false;
        }
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum = sum * 10 + sb.charAt(i) - '0';
            if (sum > 255) return false;
        }
        return true;
    }
}

