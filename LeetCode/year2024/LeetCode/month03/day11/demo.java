package LeetCode.month03.day11;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/3/11 11:10
 */
public class demo {
    public String capitalizeTitle(String title) {
        StringBuilder sb = new StringBuilder();
        for (String s : title.split(" ")) {
            if (s.length() > 2) {
                sb.append(s.substring(0, 1).toUpperCase());
                s = s.substring(1);
            }
            sb.append(s.toLowerCase());
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() -1);
        return sb.toString();
    }

    public String capitalizeTitle1(String title) {
        String[] s = title.split(" ");
        for (int i = 0; i < s.length; i++) {
            if (s[i].length() <= 2) {
                s[i] = AllSmall(s[i]);
            } else {
                s[i] = FirstBig(s[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            sb.append(s[i]).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public String AllSmall(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur >= 'a' && cur <= 'z') {
                sb.append(cur);
            } else {
                sb.append((char) (cur - 'A' + 'a'));
            }
        }
        return sb.toString();
    }

    public String FirstBig(String s) {
        StringBuilder sb = new StringBuilder();
        if (s.charAt(0) >= 'a' && s.charAt(0) <= 'z') {
            sb.append((char) (s.charAt(0) - 'a' + 'A'));
        } else {
            sb.append(s.charAt(0));
        }
        sb.append(AllSmall(s.substring(1, s.length())));
        return sb.toString();
    }
}

