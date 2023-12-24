package month09.day12;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/9/12 12:51
 */
public class demo3 {
    public int search(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
//        特判
        if (arr[0] == target) {
            return 0;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
//                找到最小值，因为有重复值
                while (mid > 0 && arr[mid - 1] == target) {
                    mid--;
                }
                return mid;
            }
//               表明前半段有序
            if (arr[mid] > arr[left]) {
//               判断该数字是否在有序半段中
                if (target < arr[mid] && target >= arr[left]) {
//                    该数字在前半段有序半段中，缩小范围
                    right = mid - 1;
                } else {
//                    该数字在后半段无序半段中，缩小范围
                    left = mid + 1;
                }
            } else if (arr[mid] < arr[left]) {
//               后半段有序
                if (target > arr[mid] && target <= arr[right]) {
//                    该数字在后半段有序半段中，缩小范围
                    left = mid + 1;
                } else {
//                    该数字在前半段无序半段中，缩小范围
                    right = mid - 1;
                }
            } else {
//                无法判断前后半段是否有序，但是mid 与left 对应的值相等且不等于target，所以可以让left++，压缩区间，因为当前的left一定不是我们要的索引
                left++;
            }
        }
        return -1;
    }
}

