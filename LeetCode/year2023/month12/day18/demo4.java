package month12.day18;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/18 14:46
 */
public class demo4 {

    public int maxAliveYear(int[] birth, int[] death) {
        int[] people = new int[101];
        for (int i = 0; i < birth.length; i++) {
            people[birth[i] - 1900]++;
            if (death[i] == 2000) continue;
            people[death[i] - 1900 + 1]--;
        }
        int res = 0, max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < 101; i++) {
            sum += people[i];
            if (sum > max) {
                max = sum;
                res = i + 1900;
            }
        }
        return res;
    }

    public int maxAliveYear1(int[] birth, int[] death) {
        int[] res = new int[101];
        for (int i = 0; i < birth.length; i++) {
            int start = birth[i];
            int end = death[i];
            for (int j = start; j <= end; j++) {
                res[j - 1900]++;
            }
        }
        int result = 0;
        for (int i = 1; i < 101; i++) {
            if (res[i] > res[result]) {
                result = i;
            }
        }
        return result + 1900;
    }
}

