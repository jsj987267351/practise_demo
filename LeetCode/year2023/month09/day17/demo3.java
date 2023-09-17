package month09.day17;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/living-people-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/9/17 13:49
 */
public class demo3 {
    public int maxAliveYear1(int[] birth, int[] death) {
//        用来记录每年共存活多少人
        int[] res = new int[101];
        for (int i = 0; i < birth.length; i++) {
            int start = birth[i];
            int end = death[i];
            while (start <= end) {
                res[start - 1900]++;
                start++;
            }
        }
        int max = 0;
        for (int i = 1; i < 101; i++) {
            if (res[i] > res[max]) {
                max = i;
            }
        }
        return max + 1900;
    }


    public int maxAliveYear(int[] birth, int[] death) {
//        记录每年的生人与死人的差值,当前生人那么当年的总人数就+1，当年去世，那么下一年的总人数就--
        int[] res = new int[101];
        for (int i = 0; i < birth.length; i++) {
            res[birth[i] - 1900]++;
//            如果是2000年去世的话，直接跳过，因为2001年才算少人
            if (death[i] == 2000) continue;
//            死人的第二年才算少人
            res[death[i] - 1900 + 1]--;
        }
//        如果res[i] ==0 代表当年既没人出生，前一年也没人去世，总人口则与前一年一样，所以从头遍历找出出生与死亡差值最大的一年即可
        int year = 1900 , max = 0, sum = 0;
        for (int i = 0; i < 101; i++) {
            sum+=res[i];
            if (sum > max){
                year = i+1900;
                max = sum;
            }
        }
        return year;
    }
}

