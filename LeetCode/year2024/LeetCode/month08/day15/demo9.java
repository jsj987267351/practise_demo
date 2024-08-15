package LeetCode.month08.day15;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/8/15 11:09
 */
public class demo9 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String res = strs[0];
        for (String str : strs) {
            while (!str.startsWith(res)) {
                res = res.substring(0, res.length() - 1);
            }
        }
        return res;
    }
}

