package month10.day06;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/6 12:24
 */
public class demo2 {
    class Trie {
        Set<String> setNoPrefix;
        Set<String> setPrefix;

        public Trie() {
//            一个存放所有前缀，一个直接存放单词
            setNoPrefix = new HashSet<>();
            setPrefix = new HashSet<>();
        }

        public void insert(String word) {
//            单词直接插入单词set中，前缀的话把所有前缀都插入到前缀set中
            setNoPrefix.add(word);
            for (int i = 1; i <= word.length(); i++) {
                setPrefix.add(word.substring(0, i));
            }
        }

        public boolean search(String word) {
//            只查单词,就查单词set
            return setNoPrefix.contains(word);
        }

        public boolean startsWith(String prefix) {
//          查前缀就查前缀set
            return setPrefix.contains(prefix);
        }
    }

}

