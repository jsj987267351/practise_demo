package month10.day24;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/24 13:07
 */
public class demo4 {
    public boolean backspaceCompare1(String s, String t) {
        StringBuilder sbs = new StringBuilder();
        StringBuilder sbt = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#' && sbs.length() > 0) {
                sbs.deleteCharAt(sbs.length() - 1);
            } else if (s.charAt(i) != '#') {
                sbs.append(s.charAt(i));
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#' && sbt.length() > 0) {
                sbt.deleteCharAt(sbt.length() - 1);
            } else if (t.charAt(i) != '#') {
                sbt.append(t.charAt(i));
            }
        }
        return sbs.toString().equals(sbt.toString());
    }

    public boolean backspaceCompare(String s, String t) {
        return reverse(s).equals(reverse(t));
    }

    public String reverse(String s) {
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '#'){
                sum++;
            }else if (sum == 0){
                sb.append(s.charAt(i));
            }else {
                sum--;
            }
        }
        return sb.toString();
    }
}

