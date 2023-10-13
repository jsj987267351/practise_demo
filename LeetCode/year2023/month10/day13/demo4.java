package month10.day13;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/13 12:15
 */
public class demo4 {
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int left = 0, right = 0;
            while (right < res.length()) {
                while (right < res.length() && res.charAt(left) == res.charAt(right)) {
                    right++;
                }
                sb.append(right - left).append(res.charAt(left));
                left = right;
            }
            res = sb.toString();
        }
        return res;
    }
}

