package LeetCode.month06.shenXinFu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/21 20:30
 */
public class demo4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer, int[]> map = new HashMap<>();
        StringBuilder sb;
        for (int i = 0; i < n; i++) {
            map.clear();
            int sum = scanner.nextInt();
            int index = 1;
            for (int j = 0; j < sum; j++) {
                int num1 = scanner.nextInt();
                int num2 = scanner.nextInt();
                map.put(num2, new int[]{num1, index});
                index++;
            }
            sb = new StringBuilder();
            int key = 0;
            while (map.containsKey(key)) {
                int[] ints = map.get(key);
                sb.append(ints[0]).append(" ");
                key = ints[1];
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb.toString());
        }
        scanner.close();
    }
}

