package LeetCode.month06.shenXinFu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/21 19:35
 */
public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < m; j++) {
            map.clear();
            String line = scanner.next();
            char[] charArray = line.toCharArray();
            map.put(charArray[0], 1);
            for (int i = 1; i < charArray.length; i++) {
                if (charArray[i] != charArray[i - 1]) {
                    map.put(charArray[i], map.getOrDefault(charArray[i], 0) + 1);
                }
            }
            int count = 0;
            for (int value : map.values()) {
                if (value > n) count++;
            }
            System.out.println(count == 0 ? 1 : count);

        }
        scanner.close();
    }
}

