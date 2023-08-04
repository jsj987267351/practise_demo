package month08.day04;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
 * <p>
 * 根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，并且每篇论文 至少 被引用 h 次。如果 h 有多种可能的值，h 指数 是其中最大的那个。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/h-index
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/8/4 18:54
 */
public class demo1 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
//            h为满足当前满足的最大值，因为是升序，所以  citations.length - i 代表着大于等于citations[i]的数量
            int h = citations.length - i;
//            如果已经小于等于了，说明后面都不满足要求了，当前就已经是最大值了
            if (h <= citations[i]) {
                return h;
            }
        }
        return 0;
    }
}

