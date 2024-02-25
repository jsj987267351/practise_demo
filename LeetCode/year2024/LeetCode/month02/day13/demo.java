package LeetCode.month02.day13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/2/13 10:29
 */
public class demo {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> list = new ArrayList<>();
        DFS(root, 0, 0, list);
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[2] - o2[2];
                }
            }
        });
        List<List<Integer>> res = new ArrayList<>();
        int lastCol = Integer.MAX_VALUE;
        int size = 0;
        for (int[] cur : list) {
            if (cur[0] != lastCol) {
                res.add(new ArrayList<>());
                lastCol = cur[0];
                size++;
            }
            res.get(size - 1).add(cur[2]);
        }
        return res;
    }

    public void DFS(TreeNode root, int col, int row, List<int[]> list) {
        if (root == null) return;
        list.add(new int[]{col, row, root.val});
        DFS(root.left, col - 1, row + 1, list);
        DFS(root.right, col + 1, row + 1, list);
    }
}

