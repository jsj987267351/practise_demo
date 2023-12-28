package month12.day28;

import java.util.*;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/28 12:55
 */
public class demo2 {
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<String> res = new ArrayList<>();
        if (!wordList.contains(endWord)) return res;
        boolean[] used = new boolean[wordList.size()];
        Map<String, String> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        boolean flag = false;
        while (!queue.isEmpty()) {
            String head = queue.poll();
            if (head.equals(endWord)){
                flag = true;
                break;
            }
            for (int i = 0; i < wordList.size(); i++) {
                if (!used[i] && compare(head, wordList.get(i))) {
                    used[i] = true;
                    queue.add(wordList.get(i));
                    map.put(wordList.get(i), head);
                }
            }
        }
        if (!flag) return res;
        String key = endWord;
        while (!map.get(key).equals(beginWord)) {
            res.add(key);
            key = map.get(key);
        }
        res.add(key);
        res.add(beginWord);
        Collections.reverse(res);
        return res;
    }

    public boolean compare(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
            if (diff > 1) return false;
        }
        return true;
    }
}

