package month12.day09;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/9 13:54
 */
public class demo1 {
    public int nextBeautifulNumber(int n) {
        for (int i = n + 1; i <= 1224444; i++) {
            if (help(i)) {
                return i;
            }
        }
        return -1;
    }

    public boolean help(int n) {
        int[] ints = new int[10];
        while (n > 0) {
            int num = n % 10;
            n /= 10;
            ints[num]++;
        }
        for (int i = 0; i < 10; i++) {
            if (ints[i] != 0 && ints[i] != i ) {
                return false;
            }
        }
        return true;
    }
}

