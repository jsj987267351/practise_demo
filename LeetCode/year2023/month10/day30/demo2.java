package month10.day30;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/h-index-ii/description/?envType=daily-question&envId=2023-10-30
 * @date 2023/10/30 11:36
 */
public class demo2 {
    public int hIndex(int[] citations) {
//        因为数组已经有序
        int len = citations.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
//            当前满足的最大h，有h个文献至少被引用了citations[mid]次
            int h = len - mid;
            if (citations[mid] > h) {
//               说明后续包括本身都不满足条件，往左边缩减区间，
                right = mid - 1;
            } else if (citations[mid] < h) {
//               说明后面还有满足条件的更大值，区间向右缩减
                left = mid + 1;
            } else {
//               如果等于的话，那么当前mid就是最大值了,可以直接返回
                return h;
            }
        }
//        最后left就是满足的最大文献的索引下标值
        return len - left;
    }
}

