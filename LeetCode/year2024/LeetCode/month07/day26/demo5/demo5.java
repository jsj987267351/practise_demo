package LeetCode.month07.day26.demo5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/26 10:18
 */
public class demo5 {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> list = new ArrayList<>();
        DFS(root, list);
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (Integer query : queries) {
            List<Integer> tmp = new ArrayList<>();
            int index = findIndex(arr, query);
            int max = index == arr.length ? -1 : arr[index];
            if (index == arr.length || arr[index] != query) {
                index--;
            }
            int min = index < 0 ? -1 : arr[index];
            tmp.add(min);
            tmp.add(max);
            res.add(tmp);
        }
        return res;
    }

    public int findIndex(int[] arr, int num) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public void DFS(TreeNode root, List<Integer> list) {
        if (root != null) {
            DFS(root.left, list);
            list.add(root.val);
            DFS(root.right, list);
        }
    }
}

