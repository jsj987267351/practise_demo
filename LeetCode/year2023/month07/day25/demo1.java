package month07.day25;

import java.util.PriorityQueue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个正整数数组 nums 。每一次操作中，你可以从 nums 中选择 任意 一个数并将它减小到 恰好 一半。（注意，在后续操作中你可以对减半过的数继续执行操作）
 * <p>
 * 请你返回将 nums 数组和 至少 减少一半的 最少 操作数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-operations-to-halve-array-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/25 12:32
 */
public class demo1 {
    public int halveArray(int[] nums) {
//        使用大顶堆，每次将最大的堆顶元素减半然后重新加入堆，并且比较判断计数即可
        PriorityQueue<Double> maxHeap = new PriorityQueue<>((a, b) -> b.compareTo(a));
        double sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            maxHeap.add(num * 1.0);
        }
        double target = sum / 2.0;
        while (true) {
            double max = maxHeap.poll();
            double num = max / 2.0;
            maxHeap.add(num);
            sum -= num;
            count++;
            if (sum <= target) {
                return count;
            }
        }
    }
}

