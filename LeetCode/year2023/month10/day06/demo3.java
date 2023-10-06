package month10.day06;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/6 12:42
 */
public class demo3 {
//    对于this找到根节点不好理解的看这个
    class Trie {
//        定义每个节点的形态
        class TrieNode {
            boolean isTail = false;
            TrieNode[] children;

            public TrieNode() {
                children = new TrieNode[26];
            }
        }
        //         根节点
        TrieNode root;

        public Trie() {
//            初始化根节点
            root = new TrieNode();
        }

        public void insert(String word) {
//        从根节点开始遍历查找
            TrieNode head = root;
//            从头开始遍历
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
//                拿到该字符对应的索引
                int index = c - 'a';
//                从头挨个字符比较，没有的话就创建，表明开始分裂，有的话就继续往下遍历
                if (head.children[index] == null) {
                    head.children[index] = new TrieNode();
                }
//                指针继续往下走
                head = head.children[index];
            }
//            遍历结束后，当前节点就走到了单词得最后一个字符，将当前设置为尾部字符
            head.isTail = true;
        }

        public boolean search(String word) {
//            查找 word 在树中是否存在，并且不能是前缀存在，所以也就是调用 searchPrefix 方法并且保证返回的是单词的最后一个节点,也就是返回的节点的 isTail 要等于true
            TrieNode node = searchPrefix(word);
            return node != null && node.isTail;
        }

        public boolean startsWith(String prefix) {
//            前缀的话只需要当前单词在树中是否存在即可，不需要返回的是单词的最后一个节点
            return searchPrefix(prefix) != null;
        }

        //        传过来一个字符串，找到当前字符串在树中是否存在，不存在的话就返回null，存在的话返回当前字符串的最后一个字母所在的节点
        public TrieNode searchPrefix(String prefix) {
//            首先拿到头节点
            TrieNode head = root;
//            开始遍历
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                int index = c - 'a';
//                字母在树中挨个比较，未走到结尾时有字母不匹配，则表明当前单词不存在
                if (head.children[index] == null) {
                    return null;
                }
//                继续匹配下一个字母
                head = head.children[index];
            }
//            head走到这就到了当前单词最后一个字母所在节点
            return head;
        }
    }
}

