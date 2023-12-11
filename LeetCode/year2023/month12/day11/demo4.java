package month12.day11;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/11 13:26
 */
public class demo4 {
    public int reversePairs(int[] record) {
        int length = record.length;
        if (length < 2) {
            return 0;
        }
        int[] temp = new int[length];
        return reversePairs(record, 0, length - 1, temp);
    }


    private int reversePairs(int[] record, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftSum = reversePairs(record, left, mid, temp);
        int rightSum = reversePairs(record, mid + 1, right, temp);
        if (record[mid] < record[mid + 1]) {
            return leftSum + rightSum;
        }
        int crossPairs = mergeAndCount(record, left, mid, right, temp);
        return leftSum + crossPairs + rightSum;
    }

    private int mergeAndCount(int[] record, int left, int mid, int right, int[] temp) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            temp[i] = record[i];
        }
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                record[k] = temp[j++];
            } else if (j == right + 1 || temp[i] <= temp[j]) {
                record[k] = temp[i++];
            } else {
                record[k] = temp[j++];
                count += (mid - i + 1);
            }
        }
        return count;
    }
}

