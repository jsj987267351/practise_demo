package LeetCode.month03.day21;


import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/3/21 12:33
 */
public class demo {
    class FrequencyTracker {
        //        用来统计每个数字出现的频率
        Map<Integer, Integer> map;
        //        用来统计每个频率出现的频率
        int[] fre;

        public FrequencyTracker() {
            map = new HashMap<>();
            fre = new int[100010];
        }

        public void add(int number) {
//            先更新之前的频率
            if (map.containsKey(number) && map.get(number) > 0) {
                fre[map.get(number)]--;
            }
//            更新之后的频率
            map.put(number, map.getOrDefault(number, 0) + 1);
            fre[map.get(number)]++;
        }

        //        是指当前数字只删除一个
        public void deleteOne(int number) {
            if (!map.containsKey(number) || map.get(number) == 0) return;
            fre[map.get(number)]--;
            map.put(number, map.get(number) - 1);
            fre[map.get(number)]++;
        }

        public boolean hasFrequency(int frequency) {
            return fre[frequency] > 0;
        }
    }
}

