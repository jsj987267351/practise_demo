package LeetCode.month07.day11;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/11 10:21
 */
public class demo5 {
    private final static int[] Fn = new int[1001];

    static {
        for (int i = 1; i <= 1000; i++) {
            Fn[i] = Fn[i - 1] + (isPunishmentNumber(String.valueOf(i * i), 0, i) ? i * i : 0);
        }
    }

    public int punishmentNumber(int n) {
        return Fn[n];
    }

    public static boolean isPunishmentNumber(String s, int index, int target) {
        if (target < 0) {
            return false;
        } else if (target == 0 && index == s.length()) {
            return true;
        } else {
            for (int i = index; i < s.length(); i++) {
                String cur = s.substring(index, i + 1);
                if (isPunishmentNumber(s, i + 1, target - Integer.parseInt(cur))) {
                    return true;
                }
            }
        }
        return false;
    }
}

