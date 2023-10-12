package month10.day12;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/fan-zhuan-dan-ci-shun-xu-lcof/?envType=list&envId=RxT23Yqb
 * @date 2023/10/12 12:48
 */
public class demo4 {
    public String reverseMessage(String message) {
        StringBuilder res = new StringBuilder();
        String[] messages = message.trim().split(" ");
        for (int i = messages.length - 1; i >= 0; i--) {
            if (messages[i].equals("")) continue;
            res.append(messages[i]).append(" ");
        }
        return res.toString().trim();
    }

    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder res = new StringBuilder();
//       切割字符串时该字符串的尾部以及头部
        int tail = s.length() - 1, head = tail;
        while (head >= 0) {
//            因为开始已经trim了，所以开头末尾一定没有空格，先找到最后一个单词的头部
            while (head >= 0 && s.charAt(head) != ' ') head--;
//            此时的head找到了最后一个单词的前一个空格，然后利用substring添加即可(左闭右开)
            res.append(s.substring(head + 1, tail + 1)).append(" ");
//            中间可能有多余空格,需要找到下一个单词的尾部
            while (head >= 0 && s.charAt(head) == ' ') head--;
//            此时的head到达了下一个单词的尾部，更新尾部后继续下次循环
            tail = head;
        }
        return res.toString().trim();
    }
}

