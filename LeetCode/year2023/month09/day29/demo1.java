package month09.day29;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/re-space-lcci/solutions/322866/jian-dan-dp-trieshu-bi-xu-miao-dong-by-sweetiee/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/9/29 15:29
 */
public class demo1 {
    public int respace1(String[] dictionary, String sentence) {
//        首先转成set集合容易查看是否存在
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        int len = sentence.length();
//        dp[i]表示前长度为i的字符串有多少未识别的字符
        int[] dp = new int[len + 1];
        for (int i = 1; i <= len; i++) {
//            刚开始默认为长度-1的字符串+1，后续遍历不断更新
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < i; j++) {
//                如果j到i的字符串存在，那么dp[i]就与dp[j]未识别的字符一样多,substring为左闭右开，因为我们使用的长度比对应下标要+1，所以右开刚好
                if (set.contains(sentence.substring(j, i))) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        return dp[len];
    }

    public int respace(String[] dictionary, String sentence) {
//          与上述同理，不过不在每走一步都比较，而是使用选中固定长度比较
        int len = sentence.length();
        int[] dp = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            dp[i] = dp[i - 1] + 1;
//            从字典中遍历选取单词，每次从当前位置往前选中单词的长度,查看是否存在
            for (String s : dictionary) {
                int length = s.length();
                if (length <= i && s.equals(sentence.substring(i - length, i))) {
                    dp[i] = Math.min(dp[i], dp[i - length]);
                }
            }
        }
        return dp[len];
    }
}

