package LeetCode.month07.day10;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/10 10:47
 */
public class demo6 {
    public int hIndex(int[] citations) {
        int left = 0, right = citations.length - 1, len = citations.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            int h = len - mid;
            if (h < citations[mid]) {
                right = mid - 1;
            } else if (h > citations[mid]) {
                left = mid + 1;
            } else {
                return h;
            }
        }
        return len - left;
    }
}

