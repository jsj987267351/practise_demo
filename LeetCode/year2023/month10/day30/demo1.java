package month10.day30;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/h-index/
 * @date 2023/10/30 11:15
 */
public class demo1 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int length = citations.length;
        for (int i = 0; i < length; i++) {
            int h = length - i;
            if (h <= citations[i]) {
                return h;
            }
        }
        return 0;
    }
}

