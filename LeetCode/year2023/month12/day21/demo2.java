package month12.day21;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/21 14:52
 */
public class demo2 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int res = 0;
        for (int[] envelope : envelopes) {
            int index = binarySearch(envelopes, res, envelope[1]);
            envelopes[index] = envelope;
            if (index == res){
                res++;
            }
        }
        return res;
    }

    private int binarySearch(int[][] envelopes, int right, int value) {
        int left = -1;
        while (left +1 < right){
            int mid = (left + right)/2;
            if (envelopes[mid][1] < value){
                left = mid;
            }else {
                right = mid;
            }
        }
        return right;
    }
}

