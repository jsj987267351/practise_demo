package LeetCode.month07.day10;

import java.util.*;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/10 9:35
 */
public class demo1 {
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<String> res = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Map<String, String> map = new HashMap<>();
        boolean[] used = new boolean[wordList.size()];
        if (!wordList.contains(endWord)) {
            return res;
        }
        queue.offer(beginWord);
        boolean flag = false;
        while (!queue.isEmpty()) {
            String head = queue.poll();
            if (head.equals(endWord)) {
                flag = true;
                break;
            }
            for (int i = 0; i < wordList.size(); i++) {
                if (!used[i] && compare(wordList.get(i), head)) {
                    used[i] = true;
                    queue.offer(wordList.get(i));
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

    public boolean compare(String a, String b) {
        if (a.length() != b.length()) return false;
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
                if (count > 1) return false;
            }
        }
        return true;
    }
}

