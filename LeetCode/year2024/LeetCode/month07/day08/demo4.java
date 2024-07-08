package LeetCode.month07.day08;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/8 9:45
 */
public class demo4 {
    public int search(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        if (arr[0] == target) return 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                while (mid > 0 && arr[mid - 1] == target) {
                    mid--;
                }
                return mid;
            }
            if (arr[mid] < arr[right]) {
//                右边有序
                if (arr[mid] < target && arr[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (arr[mid] > arr[right]) {
                if (target >= arr[left] && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }else {
                right--;
            }
        }
        return -1;
    }
}

