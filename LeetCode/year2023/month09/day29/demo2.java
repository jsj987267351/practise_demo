package month09.day29;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/9/29 15:49
 */
public class demo2 {
    public String longestWord(String[] words) {
//        先将数组排序，长度降序，长度相等的话按照字典序升序
        Arrays.sort(words, (a, b) -> {
            return a.length() == b.length() ? a.compareTo(b) : b.length() - a.length();
        });
//        将数组转换为set集合容易判断
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
//            先将该字符串剔除，后续也不用加回来，因为我们是按照长度降序的，长度小的不可能由长度大的组成
            set.remove(word);
            if (help(word, set)) {
//                如果可以的话那么就返回该字符串
                return word;
            }
        }
        return "";
    }

    private boolean help(String word, Set<String> set) {
//        另一种方法求解是否可由集合中的单词组成
//        递归结束条件,如果遍历到空了，说明前面的字符串都能够组成
        int length = word.length();
        if (length == 0) return true;
        for (int i = 0; i < length; i++) {
//            每次判断0到i的单词集合中是否存在以及后续单词是否能够由set集合中的单词组成，只要能组成就直接返回true
            if (set.contains(word.substring(0, i + 1)) && help(word.substring(i + 1,length), set)) {
                return true;
            }
        }
        return false;
    }

    private boolean help1(String word, Set<String> set) {
//        判断字符串word是否可由set集合中的单词组成,与139同理
        int len = word.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i && !dp[i]; j++) {
                if (dp[j] && set.contains(word.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[len];
    }


}

