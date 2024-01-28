package Blue.month01.day23;

import java.util.*;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/23 13:20
 */
public class P8598 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int RowSum = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < RowSum; i++) {
            String[] s = scanner.nextLine().split(" ");
            for (String s1 : s) {
                list.add(Integer.parseInt(s1));
            }
        }
        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        Arrays.sort(ints);
        int m = 0, n = 0;
        for (int i = 1; i < list.size(); i++) {
            int cur = ints[i];
            if (cur == ints[i - 1]) {
                n = cur;
            }
            if (cur - ints[i - 1] > 1) {
                m = ints[i - 1] + 1;
            }
            if (m != 0 && n != 0) {
                System.out.println(m + " " + n);
                break;
            }
        }
        scanner.close();
    }
}

