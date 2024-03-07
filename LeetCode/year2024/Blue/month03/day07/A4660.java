package Blue.month03.day07;

import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/3/7 13:59
 */
public class A4660 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mod = 998244353;
        long n = scanner.nextLong();
        long groupNum = ((n - 1) * n / 2) % mod;
        long paiLieNum = 1;
        while (n > 2) {
            paiLieNum = (paiLieNum * n) % mod;
            n--;
        }
        System.out.println((groupNum * paiLieNum) % mod);
        scanner.close();
    }
}

