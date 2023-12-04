package month12.day04;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/4 13:31
 */
public class demo4 {

    public String compressString(String s) {
        if (s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char pre = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == pre) {
                count++;
            } else {
                sb.append(pre).append(count);
                count = 1;
                pre = s.charAt(i);
            }
        }
        sb.append(pre).append(count);
        return sb.length() < s.length() ? sb.toString() : s;
    }

    public String compressString1(String s) {
        if (s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            if (s.charAt(right) == s.charAt(left)) {
                sum++;
                right++;
            } else {
                sb.append(s.charAt(left)).append(sum);
                sum = 0;
                left = right;
            }
        }
        sb.append(s.charAt(left)).append(sum);
        return sb.length() < s.length() ? sb.toString() : s;
    }
}

