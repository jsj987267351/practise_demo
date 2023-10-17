package month10.day17;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/17 11:26
 */
public class demo1 {
    public int sumOfMultiples(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                res += i;
            }
        }
        return res;
    }
}

