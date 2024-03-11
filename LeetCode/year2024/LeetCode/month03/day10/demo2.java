package LeetCode.month03.day10;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/3/10 18:45
 */
public class demo2 {
    public String getHint(String secret, String guess) {
        int bullNum = 0, cowNum = 0;
        int[] s = new int[10];
        int[] g = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            char curS = secret.charAt(i);
            char curG = guess.charAt(i);
            if (curS == curG) {
                bullNum++;
            } else {
                s[curS - '0']++;
                g[curG - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            cowNum+=Math.min(s[i],g[i]);
        }
        return bullNum + "A" + cowNum + "B";
    }
}

