package LeetCode.month04.day23;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/4/23 11:37
 */
public class demo {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
//        技巧只会让生气的变成不生气，不生气的还是不生气，所以所有不生气的人数一定会加到结果中的，首先统计所有不生气的人的总数
//        并且当统计过后的不生气人数置为0，因为已经统计过了
        int happyCount = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                happyCount += customers[i];
                customers[i] = 0;
            }
        }
//        此时的 customers 数组中不为0的元素一定都是生气的人数，这时就需要使用长度为minutes的滑动窗口来统计最长连续数组
//        这样的连续数组就是我们使用技巧能够得到的最大值
        int cur = 0, count = 0;
        for (int i = 0; i < customers.length; i++) {
            cur += customers[i];
            if (i >= minutes) {
                cur -= customers[i - minutes];
            }
            count = Math.max(count, cur);
        }
//        最后返回两个的和即可
        return happyCount + count;
    }
}

