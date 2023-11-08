package month11.day08;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/find-the-longest-balanced-substring-of-a-binary-string/description/?envType=daily-question&envId=2023-11-08
 * @date 2023/11/8 12:51
 */
public class demo1 {
    public int findTheLongestBalancedSubstring(String s) {
//        统计0和1的数量，遇到0但是1的数量不为0的话，代表从这开始是新的平衡字串了，统计前面平衡字串的长度即可，并且对新的平衡字串的0和1数量重新赋值
        int res = 0;
        int numZero = 0, numOne = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0' && numOne != 0) {
                res = Math.max(res, 2 * Math.min(numOne, numZero));
                numOne = 0;
                numZero = 1;
            } else if (s.charAt(i) == '1') {
                numOne++;
            } else {
                numZero++;
            }
        }
        res = Math.max(res, 2 * Math.min(numOne, numZero));
        return res;
    }
}

