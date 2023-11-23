package month11.day23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/23 12:57
 */
public class demo4 {
    List<String> res;
    boolean[] used;

    public String[] goodsOrder(String goods) {
        res = new ArrayList<>();
        used = new boolean[goods.length()];
        char[] goodsChars = goods.toCharArray();
        Arrays.sort(goodsChars);
        StringBuilder sb = new StringBuilder();
        backtracking(goodsChars, sb);
        return res.toArray(new String[]{});
    }

    public void backtracking(char[] goodsChars, StringBuilder sb) {
        if (sb.length() == goodsChars.length) {
            res.add(sb.toString());
            return;
        }

        for (int i = 0; i < goodsChars.length; i++) {
            if (i >0 && goodsChars[i] == goodsChars[i-1] && !used[i-1] || used[i]) continue;
            used[i] = true;
            sb.append(goodsChars[i]);
            backtracking(goodsChars,sb);
            sb.deleteCharAt(sb.length()-1);
            used[i] = false;
        }
    }
}

