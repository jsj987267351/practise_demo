package LeetCode.month01.day08;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/8 11:58
 */
public class demo2 {
    //    可以先对1000个数字进行预处理
    private final static int[] Fn = new int[1001];

    static {
        for (int i = 1; i < 1001; i++) {
            Fn[i] = Fn[i - 1] + (isPunishmentNumber(String.valueOf(i * i), 0, i) ? i * i : 0);
        }
    }

    public int punishmentNumber(int n) {
//        int res = 0;
//        for (int i = 1; i <= n; i++) {
//            if (isPunishmentNumber(String.valueOf(i * i), 0, i)) {
//                res += i * i;
//            }
//        }
//        return res;
        return Fn[n];
    }

    public static boolean isPunishmentNumber(String s, int startIndex, int target) {
        if (target < 0) {
            return false;
        } else if (startIndex == s.length() && target == 0) {
            return true;
        } else {
            for (int i = startIndex; i < s.length(); i++) {
                int cur = Integer.parseInt(s.substring(startIndex, i + 1));
                if (target >= cur && isPunishmentNumber(s, i + 1, target - cur)) {
                    return true;
                }
            }
        }
        return false;
    }
}

