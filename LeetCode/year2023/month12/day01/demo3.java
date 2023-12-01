package month12.day01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/1 12:51
 */
public class demo3 {
    public int[] circularGameLosers(int n, int k) {
        boolean[] booleans = new boolean[n];
        int index = 0, temp = 1;
        while (!booleans[index]) {
            booleans[index] = true;
            index = (index + temp * k) % n;
            temp++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!booleans[i]) {
                list.add(i + 1);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}

