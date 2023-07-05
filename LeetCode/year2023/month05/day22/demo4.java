package month05.day22;

import java.util.*;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * https://leetcode.cn/problems/top-k-frequent-elements/
 * @date 2023/5/22 17:59
 */
public class demo4 {
    public  int[] topKFrequent(int[] nums, int k) {
//        key：数组中出现的数组 value ：出现的次数
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            if (map.containsKey(num)) {
//                存在，则数量+1
                map.put(num, map.get(num) + 1);
            } else {
//                不存在，则value置为1
                map.put(num, 1);
            }
        }

//        构建一个小顶堆，用来存放出现最多的前k个数字
        PriorityQueue<Integer> small = new PriorityQueue<>(new Comparator<Integer>() {
//            自定义排序规则
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });

        for (Integer key : map.keySet()) {
            if (small.size()<k){
//                未满，直接存入
                small.add(key);
            }else if (map.get(key) > map.get(small.peek())){
//                满了，但是如果出现频率比堆顶的还少的话，就不用替换，否则替换掉堆顶，然后重新堆排序
                small.remove();
                small.add(key);
            }
        }

//        将小顶堆中的元素放入数组中即可
        int[] result = new int[k];
        int i = 0;
        for (Integer value : small) {
            result[i++] = value;
        }
        return result;
    }
}

