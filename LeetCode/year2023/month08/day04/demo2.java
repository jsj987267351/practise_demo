package month08.day04;

import java.util.*;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/8/4 19:26
 */
public class demo2 {
    class RandomizedSet {
        Map<Integer, Integer> map;
        List<Integer> list;
        Random random;

        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
            random = new Random();

        }

        public boolean insert(int val) {
//            添加的时候map的value记录数字在list中的下标，因为是一直往后添加，所以下标就是数组的长度
            if (map.containsKey(val)) return false;
            int index = list.size();
            map.put(val, index);
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
//            删除的时候简单来说就是list删除的时候把最后一个元素覆盖掉删除的元素，同时更新map中移动的元素的下标
            if (!map.containsKey(val)) return false;
//            获取最后一个元素
            int lastNum = list.get(list.size() - 1);
            if (val != lastNum){
//            要删除的元素不是最后一个元素的时候才需要覆盖操作，否则的话直接删除即可
//            获取要删除的元素的下标
                int index = map.get(val);
//            将最后一个元素覆盖在要删除的元素的下标上
                list.set(index, lastNum);
//            更新在map中的下标
                map.put(lastNum, index);
            }
//            然后就可以删除最后一个元素，因为已经覆盖在前面了
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
}

