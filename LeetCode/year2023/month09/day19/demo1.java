package month09.day19;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/sub-sort-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/9/19 12:00
 */
public class demo1 {
    public int[] subSort1(int[] array) {
//        复制克隆数组，然后比较即可。第一个不同的数字一定是开头，每次遇到不同都给结尾赋值，而开头只有第一次遇到不同才赋值
        int start = -1, end = -1;
        int[] clone = array.clone();
        Arrays.sort(clone);
        for (int i = 0; i < array.length; i++) {
            if (array[i] != clone[i]) {
                if (start == -1) {
                    start = i;
                }
                end = i;
            }
        }
        return new int[]{start, end};
    }

    public int[] subSort(int[] array) {
//        这里的中间值可以理解为从左往右遍历的话，就是该遍历到的值的左边，从右往左相反
//        左侧的值比中间最小的值大的话，那么他一定不符合递增规则
//        右侧的值比中间最大的值小的话，那么他一定不符合递增规则
        int start = -1, end = -1;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int len = array.length;
        for (int i = 0; i < len; i++) {
//            从前往后遍历比较的是右侧的值,比中间最大值大或等于的话就更新最大值，因为符合递增规则
            if (array[i] >= max) {
                max = array[i];
            } else {
//                否则用end记录下标，当前下标就是遍历过程中的不符合规则的结尾下标
                end = i;
            }
//            从后往前比较用length -i -1 ，比较左侧的值，比中间最小值小或等于的话，符合规则，更新最大值
            if (array[len - i - 1] <= min) {
                min = array[len - i - 1];
            } else {
//                不符合规则就记录下标
                start = len - i - 1;
            }
        }
        return new int[]{start, end};
    }
}

