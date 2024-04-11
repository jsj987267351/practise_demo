package LeetCode.month04.day07;

import java.util.*;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/4/7 11:59
 */
public class demo {
    class ThroneInheritance {
        Map<String, List<String>> map;
        Set<String> set;
        String king;

        public ThroneInheritance(String kingName) {
            map = new HashMap<>();
            set = new HashSet<>();
            king = kingName;
            map.put(king, new ArrayList<>());
        }

        public void birth(String parentName, String childName) {
            List<String> children = map.getOrDefault(parentName, new ArrayList<>());
            children.add(childName);
//            这里需要重新放入，因为可能children是null，也就是map中本身没有这个列表，就没有引用
            map.put(parentName,children);
        }

        public void death(String name) {
            set.add(name);
        }

        public List<String> getInheritanceOrder() {
            List<String> res = new ArrayList<>();
            DFS(res, king);
            return res;
        }

        public void DFS(List<String> res, String name) {
            if (!set.contains(name)) res.add(name);
            if (map.containsKey(name)) {
                for (String children : map.get(name)) {
                    DFS(res, children);
                }
            }
        }
    }
}

