package LeetCode.month06.day17;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/17 13:45
 */
public class demo1 {
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder cur = new StringBuilder();
            int left = 0,right = 0;
            while (right < res.length()){
                while (right < res.length() && res.charAt(left) == res.charAt(right)){
                    right++;
                }
                cur.append(right - left).append(res.charAt(left));
                left = right;
            }
            res = cur.toString();
        }
        return res;
    }
}

