package LeetCode.month05.day22;

import java.util.*;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/5/22 11:32
 */
public class demo {
    public List<List<Integer>> findWinners(int[][] matches) {
        int[] lossCount = new int[100010];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < matches.length; i++) {
            int win = matches[i][0];
            int loss = matches[i][1];
            lossCount[loss]++;
            set.add(win);
            set.add(loss);
        }
        List<Integer> list0 = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < lossCount.length; i++) {
            if (!set.contains(i)) continue;
            int cur = lossCount[i];
            if (cur == 0) {
                list0.add(i);
            } else if (cur == 1) {
                list1.add(i);
            }
        }
        Collections.sort(list0);
        Collections.sort(list1);
        res.add(list0);
        res.add(list1);
        return res;
    }
}

