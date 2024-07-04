package LeetCode.month07.day04;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/4 10:38
 */
public class demo9 {
    public int reversePairs(int[] record) {
        int len = record.length;
        if (len < 2) return 0;
        int[] temp = new int[len];
        return reversePairs(record, 0, len - 1, temp);
    }

    public int reversePairs(int[] record, int left, int right, int[] temp) {
        if (left == right) return 0;
        int mid = (left + right) / 2;
        int leftCount = reversePairs(record, left, mid, temp);
        int rightCount = reversePairs(record, mid + 1, right, temp);
        if (record[mid] < record[mid + 1]) {
            return leftCount + rightCount;
        }
        int curCount = merge(record, left, mid, right, temp);
        return curCount + leftCount + rightCount;
    }

    public int merge(int[] record, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = record[i];
        }
        int resCount = 0;
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                record[k] = temp[j++];
            } else if (j == right + 1 || temp[i] <= temp[j]) {
                record[k] = temp[i++];
            } else {
                record[k] = temp[j++];
                resCount += (mid - i + 1);
            }
        }
        return resCount;
    }
}

