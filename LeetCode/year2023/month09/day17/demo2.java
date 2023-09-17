package month09.day17;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/smallest-difference-lcci/description/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/9/17 13:20
 */
public class demo2 {
    public int smallestDifference(int[] a, int[] b) {
        long res = Integer.MAX_VALUE;
        long temp;
        Arrays.sort(a);
        Arrays.sort(b);
        int indexa = 0, indexb = 0;
        while (indexa < a.length && indexb < b.length) {
            temp = a[indexa] - b[indexb];
            res = Math.min(res, Math.abs(temp));
            if (temp > 0) {
//                每次让小的那个往后走，因为大的往后走的话差值只会更大
                indexb++;
            } else {
                indexa++;
            }
        }
        return (int) res;
    }
}

