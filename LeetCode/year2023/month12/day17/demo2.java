package month12.day17;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/17 20:00
 */
public class demo2 {
    public int takeAttendance(int[] records) {
        int left = 0, right = records.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (records[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return left;
    }
}

