package month12.day20;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/20 15:27
 */
public class demo6 {
    public int[] masterMind(String solution, String guess) {
        int[] res = new int[2];
        int num = 0, num1 = 0;
        Set<Integer> set = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            if (solution.charAt(i) == guess.charAt(i)) {
                num++;
                set.add(i);
            } else {
                map.put(solution.charAt(i), map.getOrDefault(solution.charAt(i), 0) + 1);
            }
        }
        res[0] = num;
        for (int i = 0; i < 4; i++) {
            if (set.contains(i)) continue;
            if (!map.containsKey(guess.charAt(i))) continue;
            num1++;
            map.put(guess.charAt(i), map.get(guess.charAt(i)) - 1);
            if (map.get(guess.charAt(i)) == 0) {
                map.remove(guess.charAt(i));
            }
        }
        res[1] = num1;
        return res;
    }
}

