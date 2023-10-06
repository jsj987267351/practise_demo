package month10.day06;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/implement-trie-prefix-tree/?envType=study-plan-v2&envId=top-100-liked
 * @date 2023/10/6 12:08
 */
public class demo1 {
    class Trie {
//        一般树都是存储左右两个节点，而每个字母的下一个字母有26种可能，所以使用26的数组，普通树的value值在这里表示为数组的下标，查找的时候只要对应下标节点存在就与value值存在一个意义
        Trie[] children;
        //        每个节点字符是否为当前单词的尾部
        boolean isTail;

        public Trie() {
            children = new Trie[26];
            isTail = false;
        }

        public void insert(String word) {
//        插入时要找到插入位置，所以先拿到头节点
            Trie head = this;
//            从头开始遍历
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
//                拿到该字符对应的索引
                int index = c - 'a';
//                从头挨个字符比较，没有的话就创建，表明开始分裂，有的话就继续往下遍历
                if (head.children[index] == null) {
                    head.children[index] = new Trie();
                }
//                指针继续往下走
                head = head.children[index];
            }
//            遍历结束后，当前节点就走到了单词得最后一个字符，将当前设置为尾部字符
            head.isTail = true;
        }

        public boolean search(String word) {
//            查找 word 在树中是否存在，并且不能是前缀存在，所以也就是调用 searchPrefix 方法并且保证返回的是单词的最后一个节点,也就是返回的节点的 isTail 要等于true
            Trie node = searchPrefix(word);
            return node != null && node.isTail;
        }

        public boolean startsWith(String prefix) {
//            前缀的话只需要当前单词在树中是否存在即可，不需要返回的是单词的最后一个节点
            return searchPrefix(prefix) != null;
        }

        //        传过来一个字符串，找到当前字符串在树中是否存在，不存在的话就返回null，存在的话返回当前字符串的最后一个字母所在的节点
        public Trie searchPrefix(String prefix) {
//            首先拿到头节点
            Trie head = this;
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

