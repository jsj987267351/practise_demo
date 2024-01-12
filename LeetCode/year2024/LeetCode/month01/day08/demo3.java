package LeetCode.month01.day08;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/8 12:13
 */
public class demo3 {
    public int hIndex(int[] citations) {
        int left = 0, right = citations.length - 1, length = citations.length;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int h = length - mid;
            if (citations[mid] < h) {
                left = mid + 1;
            } else if (citations[mid] > h) {
                right = mid - 1;
            } else {
                return h;
            }
        }
        return length - left;
    }
}

