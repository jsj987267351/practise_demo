package month09.day25;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/baby-names-lcci/solutions/137469/bing-cha-ji-si-lu-yong-hashmapzuo-95ms-by-accounto/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/9/25 16:20
 */
public class demo2 {
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
//        存储names中每个名字出现的频率,也会更新为最终结果
        Map<String, Integer> map = new HashMap<>();
//        key为子孙，value为祖宗，字典排序小的为祖宗
        Map<String, String> unionMap = new HashMap<>();
        for (String name : names) {
            int idxLeft = name.indexOf('(');
            int idxRight = name.indexOf(')');
//            substring 为左闭右开区
            int num = Integer.valueOf(name.substring(idxLeft + 1, idxRight));
            map.put(name.substring(0, idxLeft), num);
        }

        for (String synonym : synonyms) {
            int idx = synonym.indexOf(',');
            String name1 = synonym.substring(1, idx);
            String name2 = synonym.substring(idx + 1, synonym.length() - 1);
//            找到两人的祖宗
            while (unionMap.containsKey(name1)) {
                name1 = unionMap.get(name1);
            }
            while (unionMap.containsKey(name2)) {
                name2 = unionMap.get(name2);
            }

//            祖宗不同的话要合并，代表总祖宗中的这个孙子的值还没添加，相同的话代表前面遍历过并且求和过了
            if (!name1.equals(name2)) {
                int sum = map.getOrDefault(name1, 0) + map.getOrDefault(name2, 0);
//                排序靠前的当祖宗
                String grandFather = name1.compareTo(name2) < 0 ? name1 : name2;
                String grandSon = name1.compareTo(name2) < 0 ? name2 : name1;
                unionMap.put(grandSon, grandFather);
//                最终结果中只保留祖宗
                map.remove(grandSon);
                map.put(grandFather, sum);
            }
        }

        String[] res = new String[map.size()];
        int i = 0;
        for (String key : map.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(key);
            sb.append('(');
            sb.append(map.get(key));
            sb.append(')');
            res[i] = sb.toString();
            i++;
        }

        return res;
    }
}

