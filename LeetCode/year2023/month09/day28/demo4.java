package month09.day28;

import java.util.PriorityQueue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/smallest-k-lcci/description/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/9/28 17:37
 */
public class demo4 {
    public int[] smallestK(int[] arr, int k) {
//        特判
        if (k == 0){
            return new int[]{};
        }
//        使用大顶堆即可
        PriorityQueue<Integer> bigDui = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < arr.length; i++) {
            if (bigDui.size() < k) {
                bigDui.add(arr[i]);
            } else if (bigDui.peek() > arr[i]) {
                bigDui.poll();
                bigDui.add(arr[i]);
            }
        }
        int[] res = new int[bigDui.size()];
        int i = 0;
        for (Integer num : bigDui) {
            res[i++] = num;
        }
        return res;
    }
}

