package month11.day09;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/9 12:27
 */
public class demo2 {
    List<List<String>> res;
    LinkedList<String> list;

    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        list = new LinkedList<>();
        backtracking(s, 0);
        return res;
    }

    public void backtracking(String s, int index) {
        if (index == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isValid(s, index, i)) {
                list.add(s.substring(index, i + 1));
                backtracking(s, i + 1);
                list.removeLast();
            }
        }
    }

    public boolean isValid(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

