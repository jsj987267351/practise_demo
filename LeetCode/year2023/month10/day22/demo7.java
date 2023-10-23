package month10.day22;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/22 21:20
 */
public class demo7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        String line = scan.nextLine();

        int year = Integer.parseInt(line.substring(0, 4));
        int month = Integer.parseInt(line.substring(4, 6));
        int day = Integer.parseInt(line.substring(6, 8));

        LocalDate data = LocalDate.now();
        data = data.withYear(year);
        data = data.withMonth(month);
        data = data.withDayOfMonth(day);
        data = data.plusDays(1);

        String res1 = null, res2 = null;
        boolean isFind = false;
        while (true) {
            String dateStr = data.toString().replace("-", "");
            if (isHuiWen(dateStr)) {
                if (!isFind) {
                    isFind = true;
                    res1 = dateStr;
                }
                if (isABABBABA(dateStr)) {
                    res2 = dateStr;
                    break;
                }
            }
            data = data.plusDays(1);
        }
        System.out.println(res1);
        System.out.println(res2);
        scan.close();
    }

    public static boolean isHuiWen(String dateStr) {
        char[] chars = dateStr.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isABABBABA(String dateStr) {
        char[] chars = dateStr.toCharArray();
        return chars[0] == chars[2] && chars[2] == chars[5] && chars[5] == chars[7] && chars[1] == chars[3] && chars[3] == chars[4] && chars[4] == chars[6];
    }
}

