package month09.day29;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/9/29 16:30
 */
public class demo3 {
    public int[] shortestSeq(int[] big, int[] small) {
//      与76题同理
//        存储需要的元素
        Set<Integer> needs = new HashSet<>();
        for (int num : small) {
            needs.add(num);
        }
//        存储当前窗口中已经有的元素并且记录个数，
        Map<Integer, Integer> window = new HashMap<>();
//        窗口的两个边界以及窗口长度
        int left = 0, right = 0, len = Integer.MAX_VALUE;
//        最终结果的下标索引
        int start = 0, end = 0;
        while (right < big.length) {
            int num = big[right];
            right++;
            if (needs.contains(num)) {
//                说明该元素是需要的
                window.put(num, window.getOrDefault(num, 0) + 1);
            }
            while (window.size() == needs.size()) {
//                因为window只存储需要的数字，所以两个集合长度相等时代表当前窗口是满足的
//                不断更新索引
                if (right - left < len) {
                    len = right - left;
                    start = left;
//                    这里使用right -1 是因为要返回的是下标，我们在每次增加窗口时right都进行了+1
                    end = right - 1;
                }
//                不断缩小窗口
                int leftNum = big[left];
                left++;
                if (window.containsKey(leftNum)) {
//                    如果当前从窗口中删除的数字是需要的话，我们还要判断删除他之后当前窗口中是否还有该数字
                    if (window.get(leftNum) == 1) {
//                        如果只有一个的话直接从集合中删除该数字
                        window.remove(leftNum);
                    } else {
//                        否则从窗口中数量减去1即可
                        window.put(leftNum, window.get(leftNum) - 1);
                    }
                }
            }
        }
//        也可能不存在
        if (start == 0 && end == 0) {
            return new int[]{};
        }
        return new int[]{start, end};
    }
}

