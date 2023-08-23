package month08.day23;

import javax.naming.spi.ResolveResult;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定两个以 非递减顺序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 * <p>
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 * <p>
 * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
 * <p>
 * https://leetcode.cn/problems/find-k-pairs-with-smallest-sums/?envType=study-plan-v2&envId=top-interview-150
 * @date 2023/8/23 12:55
 */
public class demo1 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//        堆，堆中存放的是一个个二维数组，数组分别代表着nums1 和nums2 的索引 按照总和升序排列，最终返回前k小即可
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]));
//        首先将nums2的0号未与nums1的所有索引结合存入堆，因为数组初始是升序的,所以0号位一定是当前数组中最小的元素
        int length1 = nums1.length;
        int length2 = nums2.length;
//        初始只放入k与length1中小的值的数量即可
        for (int i = 0; i < Math.min(length1,k); i++) {
            q.offer(new int[]{i, 0});
        }
        List<List<Integer>> res = new ArrayList<>();
//        开始弹出
        while (k-- > 0 && !q.isEmpty()) {
//            当前弹出的数组一定是最小的，收集
            int[] poll = q.poll();
            List<Integer> list = new ArrayList<>();
            list.add(nums1[poll[0]]);
            list.add(nums2[poll[1]]);
            res.add(list);
//            此时的poll[1]代表的是nums2的索引,nums2的索引0与nums1的索引已经结合完毕放入堆了，所以索引往后移一位继续组合放入，具体看解析
            if (++poll[1] < length2) {
                q.offer(poll);
            }

        }
        return res;
    }
}

