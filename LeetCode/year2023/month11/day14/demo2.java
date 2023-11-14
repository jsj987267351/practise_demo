package month11.day14;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/14 15:04
 */
public class demo2 {
    List<String> res;

    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        if (s.length() <4 || s.length() > 12){
            return res;
        }
        StringBuilder sb = new StringBuilder(s);
        backtracking(sb, 0, 0);
        return res;
    }

    public void backtracking(StringBuilder sb, int startIndex, int PointSum) {
        if (PointSum == 3) {
            if (isValid(sb, startIndex, sb.length() - 1)) {
                res.add(sb.toString());
            }
            return;
        }

        for (int i = startIndex; i < sb.length(); i++) {
            if (isValid(sb, startIndex, i)) {
                sb.insert(i + 1, '.');
                backtracking(sb, i + 2, PointSum + 1);
                sb.deleteCharAt(i + 1);
            }
        }
    }


    public boolean isValid(StringBuilder s, int start, int end) {
        if (end - start > 2 || start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && end != start) {
            return false;
        }
        int sum = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return false;
            }
            sum = sum * 10 + s.charAt(i) - '0';
            if (sum > 255) {
                return false;
            }
        }
        return true;
    }
}

