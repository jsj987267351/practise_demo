package LeetCode.month07.day16;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/16 11:01
 */
public class demo9 {
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int myLen = len - k;
        int sum = 0, cur = 0, min = 0;
        for (int i = 0; i < myLen; i++) {
            sum += cardPoints[i];
            cur += cardPoints[i];
        }
        min = cur;
        for (int i = myLen; i < len; i++) {
            sum += cardPoints[i];
            cur += cardPoints[i];
            cur -= cardPoints[i - myLen];
            min = Math.min(min, cur);
        }
        return sum - min;
    }
}

