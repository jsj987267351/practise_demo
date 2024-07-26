package LeetCode.month07.day26.demo3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/26 10:08
 */
public class demo {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> list = new ArrayList<>();
        DFS(0, 0, root, list);
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
        for (int[] ints : list) {
            if (ints[0] != lastCol) {
                lastCol = ints[0];
                res.add(new ArrayList<>());
            }
            res.get(res.size() - 1).add(ints[2]);
        }
        return res;
    }

    public void DFS(int col, int row, TreeNode root, List<int[]> list) {
        if (root == null) return;
        list.add(new int[]{col, row, root.val});
        DFS(col - 1, row + 1, root.left, list);
        DFS(col + 1, row + 1, root.right, list);
    }
}

