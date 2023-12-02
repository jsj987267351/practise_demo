package month12.day02;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/2 13:21
 */
public class demo1 {

    public boolean carPooling(int[][] trips, int capacity) {
//          根据题目提示，上下车时间最大值为1000，所以创建容量10001的数组（因为包含0），下标对应着每个时间节点的剩余座位情况
        int[] seat = new int[1001];
        for (int i = 0; i < trips.length; i++) {
            seat[trips[i][1]] -= trips[i][0];
            seat[trips[i][2]] += trips[i][0];
        }
//        接着遍历每个时间节点的座位变化情况是否有空座即可
        for (int i = 0; i < 1001; i++) {
            capacity += seat[i];
            if (capacity < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean carPooling1(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> MinHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int[] trip : trips) {
            int up = trip[1];
            while (!MinHeap.isEmpty() && MinHeap.peek()[2] <= up) {
                int[] down = MinHeap.poll();
                capacity += down[0];
            }
            MinHeap.offer(trip);
            capacity -= trip[0];
            if (capacity < 0) {
                return false;
            }
        }
        return true;
    }
}

