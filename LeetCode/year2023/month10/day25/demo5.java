package month10.day25;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/25 16:42
 */
public class demo5 {
    List<Integer> res;

    public List<Integer> getRow(int rowIndex) {
        res = new ArrayList<>();
        int[] dp = new int[rowIndex + 1];
        for (int i = 0; i < rowIndex + 1; i++) {
            help(dp, i);
        }
        for (int i = 0; i < rowIndex + 1; i++) {
            res.add(dp[i]);
        }
        return res;
    }

    public void help(int[] dp, int index) {
        if (index == 0) {
            dp[0] = 1;
            return;
        }
        for (int i = index; i > 0; i--) {
            dp[i] = dp[i] + dp[i - 1];
        }
    }
}

