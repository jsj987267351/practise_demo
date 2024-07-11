package LeetCode.month07.day11;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/11 10:07
 */
public class demo3 {
    class Trie {
        class myTrie {
            boolean isTail = false;
            myTrie[] children;

            public myTrie() {
                children = new myTrie[26];
            }
        }

        myTrie root;

        public Trie() {
            root = new myTrie();
        }

        public void insert(String word) {
            myTrie head = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (head.children[index] == null) {
                    head.children[index] = new myTrie();
                }
                head = head.children[index];
            }
            head.isTail = true;
        }

        public boolean search(String word) {
            myTrie myTrie = searchPrefix(word);
            return myTrie != null && myTrie.isTail;
        }

        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        public myTrie searchPrefix(String prefix) {
            myTrie head = root;
            for (char c : prefix.toCharArray()) {
                int index = c - 'a';
                if (head.children[index] == null) {
                    return null;
                }
                head = head.children[index];
            }
            return head;
        }
    }
}

