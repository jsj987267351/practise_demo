package month09.day18;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/master-mind-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/9/18 12:57
 */
public class demo3 {
    public int[] masterMind(String solution, String guess) {
        int[] res = new int[2];
        int num = 0;
        int num2 = 0;
//        记录猜中的位置
        Set<Integer> set = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            if (solution.charAt(i) == guess.charAt(i)) {
                set.add(i);
                num++;
            }else {
//            记录当前字符出线的次数
                map.put(solution.charAt(i), map.getOrDefault(solution.charAt(i), 0) + 1);
            }
        }
        res[0] = num;
        for (int i = 0; i < 4; i++) {
            if (set.contains(i)) continue;
//            没有猜的该颜色直接跳过
            if (!map.containsKey(guess.charAt(i))) continue;
            int keyNum = map.get(guess.charAt(i));
            num2++;
            if (keyNum == 1) {
                map.remove(guess.charAt(i));
            } else {
                map.put(guess.charAt(i), keyNum - 1);
            }
        }
        res[1] = num2;
        return res;
    }
}

