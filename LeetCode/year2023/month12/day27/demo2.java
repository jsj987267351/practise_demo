package month12.day27;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/27 14:31
 */
public class demo2 {
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        Map<String, Integer> map = new HashMap<>();
        for (String name : names) {
            int left = name.indexOf("(");
            int num = Integer.valueOf(name.substring(left + 1, name.length() - 1));
            String cur = name.substring(0, left);
            map.put(cur, num);
        }
        Map<String, String> unionMap = new HashMap<>();
        for (String synonym : synonyms) {
            int index = synonym.indexOf(",");
            String name1 = synonym.substring(1, index);
            String name2 = synonym.substring(index + 1, synonym.length() - 1);
            while (unionMap.containsKey(name1)) {
                name1 = unionMap.get(name1);
            }
            while (unionMap.containsKey(name2)) {
                name2 = unionMap.get(name2);
            }
            if (!name1.equals(name2)) {
                String father = name1.compareTo(name2) < 0 ? name1 : name2;
                String son = name2.compareTo(name1) < 0 ? name1 : name2;
                unionMap.put(son, father);
                map.put(father, map.getOrDefault(father, 0) + map.getOrDefault(son, 0));
                map.remove(son);
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

