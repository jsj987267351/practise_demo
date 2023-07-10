package month07.day10;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/10 17:04
 */
public class demo2 {
    public int minDistance(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int length1 = word1.length();
        int length2 = word2.length();

//        dp[i][j]含义：以i-1 和j-1 为结尾的两个字符串转换相等的最小操作数
        int[][] dp = new int[length1 + 1][length2 + 1];

//        初始化
//        当其中一个单词不为空，而另一个单词为空的话，将两个单词转换成相等的最小操作数就是
//        将不为空的全删完，或者将空的添加成不为空的字符串
//        dp[0][0] = 0 因为两个字符串都为空的话，不用操作就相等了
        for (int i = 1; i <= length1; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= length2; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
//                如果前面字符串相等了，那么就代表前面字符串不用更改了，继续往前遍历比较
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
//                    如果字符串不相等了，那么有三种办法。增删改
//                    删和增是同理的，因为删1就等价于增2
//                    dp[i - 1][j], dp[i][j - 1] 分别代表着对两个字符串进行删除或增加后的操作，那么操作数就要在+1
//                    dp[i - 1][j - 1] 代表着对两个字符串进行更改后的操作，操作数在+1
//                    对增删改的操作数取最小值即可
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

        return dp[length1][length2];
    }
}

