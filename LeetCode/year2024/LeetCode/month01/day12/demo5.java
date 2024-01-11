package LeetCode.month01.day12;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/11 15:22
 */
public class demo5 {
    public int maxScore(int[] cardPoints, int k) {
        int cur = 0, sum = 0, min = 0;
        int length = cardPoints.length;
        int middleLength = length - k;
        for (int i = 0; i < middleLength; i++) {
            cur += cardPoints[i];
            sum += cardPoints[i];
        }
        min = cur;
        for (int i = middleLength; i < length; i++) {
            sum += cardPoints[i];
            cur += cardPoints[i];
            cur -= cardPoints[i - middleLength];
            min = Math.min(min, cur);
        }
        return sum - min;
    }
}

