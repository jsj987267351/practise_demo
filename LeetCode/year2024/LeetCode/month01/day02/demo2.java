package LeetCode.month01.day02;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/2 12:34
 */
public class demo2 {
    class Trie {
        class TrieNode {
            boolean isTail = false;
            TrieNode[] children;

            public TrieNode() {
                children = new TrieNode[26];
            }
        }

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode head = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';
                if (head.children[index] == null) {
                    head.children[index] = new TrieNode();
                }
                head = head.children[index];
            }
            head.isTail = true;
        }

        public boolean search(String word) {
            TrieNode tail = searchPrefix(word);
            return tail != null && tail.isTail;
        }

        public boolean startsWith(String prefix) {
            TrieNode tail = searchPrefix(prefix);
            return tail != null;
        }

        public TrieNode searchPrefix(String word) {
            TrieNode head = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
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

