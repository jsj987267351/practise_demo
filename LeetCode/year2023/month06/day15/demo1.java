package month06.day15;

import java.util.HashSet;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * <p>
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/word-break
 * @date 2023/6/15 12:52
 */
public class demo1 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int length = s.length();
//        动态规划，dp数组，下标含义为：dp[i]表示长度为i的字符串在 wordDict 中是否存在，这里dp[0]表示空，所以dp[s.length()]才是最终答案，数组从1开始
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
//        从1开始遍历，
        for (int i = 1; i <= length; i++) {
//            从头开始遍历，如果dp[j]存在并且j到1也存在的话，说明该字符串可以组成
            for (int j = 0; j < i && !dp[i]; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[length];
    }
}

