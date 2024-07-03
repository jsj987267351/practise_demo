package LeetCode.month07.day03;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/3 10:48
 */
public class demo8 {
    public int maxAliveYear(int[] birth, int[] death) {
        int[] arr = new int[101];
        for (int i = 0; i < birth.length; i++) {
            int live = birth[i];
            int dead = death[i];
            arr[live - 1900]++;
            if (death[i] == 2000) continue;
            arr[dead - 1900 + 1]--;
        }
        int max = Integer.MIN_VALUE, res = 1900, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > max) {
                max = sum;
                res = i + 1900;
            }
        }
        return res;
    }
}

