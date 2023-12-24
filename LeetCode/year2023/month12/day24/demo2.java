package month12.day24;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/24 17:11
 */
public class demo2 {
    public int search(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        if (arr[0] == target) {
            return 0;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                while (mid > 0 && arr[mid - 1] == target) {
                    mid--;
                }
                return mid;
            }
            if (arr[left] < arr[mid]) {
//                左边有序
                if (target >= arr[left] && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (arr[left] > arr[mid]) {
//                右边有序
                if (target <= arr[right] && target > arr[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                left++;
            }
        }
        return -1;
    }
}

