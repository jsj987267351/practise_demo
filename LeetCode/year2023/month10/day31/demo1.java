package month10.day31;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/happy-number/?envType=list&envId=hliQiQFH
 * @date 2023/10/31 11:18
 */
public class demo1 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = next(n);
        }
        return n == 1;
    }

    public int next(int n) {
        int res = 0;
        while (n != 0) {
            int temp = n % 10;
            res += temp * temp;
            n /= 10;
        }
        return res;
    }
}

