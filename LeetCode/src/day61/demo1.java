package day61;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * <p>
 * 回文串 是正着读和反着读都一样的字符串。
 * https://leetcode.cn/problems/palindrome-partitioning/?envType=study-plan-v2&envId=top-100-liked
 * @date 2023/6/12 13:25
 */
public class demo1 {
    List<List<String>> result = new ArrayList<>();
    LinkedList<String> list = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return result;
    }

    public void backtracking(String s, int startIndex) {
//       切割到头了
        if (startIndex == s.length()){
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = startIndex; i <s.length() ; i++) {
            if (help(s,startIndex,i)){
//                是回文字串,需要左闭右闭，substring为左闭右开，所以右区间需要+1
                list.add(s.substring(startIndex,i+1));
            }else
//                不是则直接跳过即可
                continue;
//            递归
            backtracking(s,i+1);
//            回溯
            list.removeLast();
        }
    }

    public boolean help(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

