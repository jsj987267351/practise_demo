package Blue.month03.day06;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/3/6 16:24
 */
public class A4652 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, int[]> map = new HashMap<>();
        int l = 1189, s = 841;
        for (int i = 0; i < 10; i++) {
            map.put("A" + i, new int[]{l, s});
            l /= 2;
            int max = Math.max(l, s);
            int min = Math.min(l, s);
            l = max;
            s = min;
        }
        String str = scanner.nextLine();
        int[] res = map.get(str);
        System.out.println(res[0]);
        System.out.println(res[1]);
        scanner.close();
    }
}

