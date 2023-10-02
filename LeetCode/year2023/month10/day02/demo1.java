package month10.day02;

import java.util.*;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/word-transformer-lcci/description/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/10/2 13:57
 */
public class demo1 {
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
//        题目意思，在字典wordList中，能否通过每次更改beginWord中的一个单词最后变更为endWord，每次变更的单词必须存在字典中
        List<String> res = new ArrayList<>();
//        使用过的单词
        boolean[] used = new boolean[wordList.size()];
//        存放转变过程的队列
        Queue<String> queue = new LinkedList<>();
//        存放字典单词中每个单词的前缀,key可由value变换而来
        Map<String, String> map = new HashMap<>();
//        首先特殊判断,如果结尾单词都不在字典中，直接返回
        if (!wordList.contains(endWord)) {
            return res;
        }
//        首先从开头开始加入队列
        queue.offer(beginWord);
//        记录是否结束
        boolean flag = false;
//        开始遍历
        while (!queue.isEmpty()) {
            String head = queue.poll();
            if (head.equals(endWord)) {
//                说明已经可以转变为结尾了，直接退出循环
                flag = true;
                break;
            }
//            从字典中找到可由其变换而来的字符串
            for (int i = 0; i < wordList.size(); i++) {
//                说明该字符串未使用过，并且可由头变换一个单词转变而来，加入队列，并且加入map集合
                if (!used[i] && compare(head, wordList.get(i))) {
                    used[i] = true;
                    queue.offer(wordList.get(i));
                    map.put(wordList.get(i), head);
                }
            }
        }
//        首先判断是否能够转换而来
        if (!flag) return res;
//        从map集合倒推出转换过程,起始位置即为 endWord
        String key = endWord;
        while (!map.get(key).equals(beginWord)) {
            res.add(key);
//           更新key
            key = map.get(key);
        }
//        把最后一对加入最终集合中
        res.add(key);
        res.add(beginWord);
//        最后取反即可，因为我们是倒推的
        Collections.reverse(res);
        return res;
    }


    //     判断两个字符串是否可以通过只改变一个字符而转变
    public boolean compare(String a, String b) {
//        记录不同字符数
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
            if (diff > 1) return false;
        }
        return true;
    }
}

