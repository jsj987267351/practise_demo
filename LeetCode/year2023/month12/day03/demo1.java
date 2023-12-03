package month12.day03;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/3 13:55
 */
public class demo1 {
    public int maxScore(int[] cardPoints, int k) {
//        找连续数组总和最小，连续数组长度为 length - k,使用滑动窗口
        int length = cardPoints.length;
        int WindowSize = length - k;
        int curSum = 0;
        for (int i = 0; i < WindowSize; i++) {
            curSum += cardPoints[i];
        }

        int min = curSum;
        int right = WindowSize, left = 0;
        while (right < length) {
            curSum += cardPoints[right];
            right++;
            curSum -= cardPoints[left];
            left++;
            min = Math.min(min, curSum);
        }
        int TotalSum = 0;
        for (int i = 0; i < length; i++) {
            TotalSum += cardPoints[i];
        }
        return TotalSum - min;
    }
}

