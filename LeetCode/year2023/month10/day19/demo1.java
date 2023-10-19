package month10.day19;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/19 12:05
 */
public class demo1 {
    public int tupleSameProduct(int[] nums) {
//        首先统计所有乘积出现的次数，因为数组中元素各不相同，所以出现相同的乘积的四个数一定是不同的
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int key = nums[i] * nums[j];
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
//        map的值为每个乘积key出现的次数，如果出现次数大于1次，代表至少存在两对数乘积相同，也就是有value对数字乘积相同，对这些数字进行排序
//        从value对数字中每次选取两对数字出来进行排序，每两对数字可排序8个排序组合（看题目示例可看出）,所以计算多少个不同两对然后*8即是当前乘积的同积元组个数
        int res = 0;
        for (int value : map.values()) {
            if (value < 2) continue;
//            value * (value - 1) / 2 就是出现的不同的两对的次数，例如3个不同数字有3对， 12 13 23 3*2/2
            res += value * (value - 1) / 2 * 8;
        }

        return res;
    }
}

