package LeetCode.month07.day09;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/9 9:58
 */
public class demo4 {
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, String> unionMap = new HashMap<>();
        for (String name : names) {
            int leftIndex = name.indexOf('(');
            map.put(name.substring(0, leftIndex), Integer.parseInt(name.substring(leftIndex + 1, name.length() - 1)));
        }
        for (String synonym : synonyms) {
            int index = synonym.indexOf(',');
            String leftName = synonym.substring(1, index);
            String rightName = synonym.substring(index + 1, synonym.length() - 1);
            while (unionMap.containsKey(leftName)) {
                leftName = unionMap.get(leftName);
            }
            while (unionMap.containsKey(rightName)) {
                rightName = unionMap.get(rightName);
            }
            if (!leftName.equals(rightName)) {
                int sum = map.getOrDefault(leftName, 0) + map.getOrDefault(rightName, 0);
                String son = leftName.compareTo(rightName) < 0 ? rightName : leftName;
                String father = leftName.compareTo(rightName) < 0 ? leftName : rightName;
                map.put(father, sum);
                map.remove(son);
                unionMap.put(son,father);
            }
        }
        String[] res = new String[map.size()];
        int index = 0;
        for (String key : map.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(key);
            sb.append("(");
            sb.append(map.get(key));
            sb.append(")");
            res[index++] = sb.toString();
        }
        return res;
    }
}

