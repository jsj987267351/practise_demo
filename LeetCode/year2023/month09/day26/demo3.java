package month09.day26;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/9/26 13:18
 */
public class demo3 {
    public int maxEnvelopes(int[][] envelopes) {
//        与300 最长递增子序列的二分查找法解法相同，不过变换为2维而已  与马戏团人塔解法完全相同
//        宽度按照升序排列，宽度相同的话高度按照降序排列
//        不能二者同为升序的原因时，宽度相同时高度升序的话，那么计算子序列就会把二者都算进去，因为宽度已经固定住只看高度了。那样是不符合要求的
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int res = 0;
        for (int[] envelope : envelopes) {
            int index = binarySearch(envelopes, res, envelope[1]);
            envelopes[index][1] = envelope[1];
            if (index == res) {
                res++;
            }
        }
        return res;
    }

    public int binarySearch(int[][] envelopes, int right, int target) {
        int left = -1;
        while (left + 1 < right) {
            int mid = (left + right) >> 1;
            if (envelopes[mid][1] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }
}

