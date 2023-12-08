package month12.day08;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/8 13:35
 */
public class demo2 {
    public String crackPassword(int[] password) {
        StringBuilder res = new StringBuilder();
        int length = password.length;
        String[] strings = new String[length];
        for (int i = 0; i < length; i++) {
            strings[i] = String.valueOf(password[i]);
        }
        Arrays.sort(strings, (a, b) -> (a + b).compareTo(b + a));
        for (String string : strings) {
            res.append(string);
        }
        return res.toString();
    }
}

