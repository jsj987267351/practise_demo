package LeetCode.month06.day19;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/19 10:54
 */
public class demo5 {
    public int hIndex(int[] citations) {
        int len = citations.length;
//        统计每个数字出现多少次
        int[] count = new int[len + 1];
        for (int citation : citations) {
//            因为如果出现的数字大于长度，也无效，不可能有这么多数字满足需求，将其降级为与长度一致
//            例如长度为5，数字为6，不可能满足6个数字大于6的，最大长度就为5，但可能满足5个大于5的
            count[Math.min(citation, len)]++;
        }
        int MaxCount = 0;
        for (int i = len; i >= 0; i--) {
//            从后往前遍历，后面都是大数字满足的个数，满足后面的话一定也满足前面的，因为后面数字更大
            MaxCount += count[i];
//            此时的i代表数组长度，如果最大满足数量也大于长度的话，那就可以直接返回了，因为越往前长度越小，而MaxCount越来越大，需要同时满足
            if (MaxCount >= i) {
                return i;
            }
        }
        return 0;
    }
}

