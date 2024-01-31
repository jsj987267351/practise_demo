package LeetCode.month01.day30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/30 13:25
 */
public class demo {
    public int minimumSeconds(List<Integer> nums) {
//        看灵神解析
//        key为数字，value为key数字所在的下标集合
        Map<Integer, List<Integer>> map = new HashMap<>();
        int len = nums.size();
        for (int i = 0; i < len; i++) {
            int cur = nums.get(i);
            if (!map.containsKey(cur)) {
                map.put(cur, new ArrayList<>());
            }
            map.get(cur).add(i);
        }
//        res为相同元素中其中两个之间的最大距离，注：题目为环形
        int res = len;
        for (List<Integer> value : map.values()) {
//            初始为环形的外圈，后续只需要关注顺序内圈即可
            int max = len - value.get(value.size() - 1) + value.get(0);
//            不断更新内圈之间的间隔最大值，因为是下标是顺序放入的，所以只需关注近邻即可
            for (int i = 1; i < value.size(); i++) {
                max = Math.max(max, value.get(i) - value.get(i - 1));
            }
//            更新，距离越小越快
            res = Math.min(res, max);
        }
//        因为是双向感染，所以速度为距离的一半
        return res / 2;
    }
}

