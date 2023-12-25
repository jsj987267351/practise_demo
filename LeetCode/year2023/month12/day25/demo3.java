package month12.day25;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/25 14:17
 */
public class demo3 {
    public List<String> getValidT9Words(String num, String[] words) {
        List<String> res = new ArrayList<>();
        char[] chars = "22233344455566677778889999".toCharArray();
        for (String word : words) {
            if (word.length() != num.length()) continue;
            int i;
            for (i = 0; i < word.length(); i++) {
                if (chars[word.charAt(i) - 'a'] != num.charAt(i)) {
                    break;
                }
            }
            if (i == word.length()) {
                res.add(word);
            }
        }
        return res;
    }
}

