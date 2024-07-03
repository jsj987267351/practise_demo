package LeetCode.month07.day03;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/3 11:11
 */
public class demo10 {
    public int[] masterMind(String solution, String guess) {
        char[] solutionArray = solution.toCharArray();
        char[] guessArray = guess.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int[] res = new int[2];
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (solutionArray[i] == guessArray[i]) {
                count++;
                set.add(i);
            } else {
                map.put(solutionArray[i], map.getOrDefault(solutionArray[i], 0) + 1);
            }
        }
        res[0] = count;
        int count2 = 0;
        for (int i = 0; i < 4; i++) {
            if (set.contains(i)) continue;
            if (!map.containsKey(guessArray[i])) continue;
            count2++;
            map.put(guessArray[i], map.get(guessArray[i]) - 1);
            if (map.get(guessArray[i]) == 0) map.remove(guessArray[i]);
        }
        res[1] = count2;
        return res;
    }
}

