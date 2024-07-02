package LeetCode.month07.day02;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/2 11:00
 */
public class demo10 {
    public int takeAttendance(int[] records) {
        int left = 0,right = records.length-1;
        while (left <= right){
            int mid = left + (right-left)/2;
            if (records[mid] == mid){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return left;
    }
}

