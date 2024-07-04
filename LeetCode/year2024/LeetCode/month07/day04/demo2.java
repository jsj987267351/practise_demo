package LeetCode.month07.day04;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/4 9:44
 */
public class demo2 {
    public String crackPassword(int[] password) {
        int len = password.length;
        String[] passStr = new String[len];
        for (int i = 0; i < len; i++) {
            passStr[i] = String.valueOf(password[i]);
        }
        Arrays.sort(passStr, (a, b) -> (a + b).compareTo(b + a));
        StringBuilder res = new StringBuilder();
        for (String s : passStr) {
            res.append(s);
        }
        return res.toString();
    }
}

