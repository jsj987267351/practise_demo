package LeetCode.month02.day24;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/2/24 12:11
 */
public class demo {
    List<Integer> arrList;

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        arrList = new ArrayList<>();
        help(root);
        int length = arrList.size();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = arrList.get(i);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int num : queries) {
            List<Integer> tmp = new ArrayList<>();
            int right = lower(arr, num);
//            判断越界
            int max = right == length ? -1 : arr[right];
            if (right == length || arr[right] != num) {
                right--;
            }
            int min = right < 0 ? -1 : arr[right];
            tmp.add(min);
            tmp.add(max);
            res.add(tmp);
        }
        return res;
    }


    //    找到第一个大于等于target的下标值
    public int lower(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) {
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public void help(TreeNode root) {
        if (root != null) {
            help(root.left);
            arrList.add(root.val);
            help(root.right);
        }
    }
}

