package month12.day20;

import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/20 14:08
 */
public class demo1 {
    public boolean isAcronym(List<String> words, String s) {
        if (words.size() != s.length()) {
            return false;
        }
        int index = 0;
        while (index < s.length()) {
            if (words.get(index).charAt(0) != s.charAt(index)) {
                return false;
            }
            index++;
        }
        return true;
    }
}

