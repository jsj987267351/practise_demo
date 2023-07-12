package month07.day12;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个正整数 n 。n 中的每一位数字都会按下述规则分配一个符号：
 * <p>
 * 最高有效位 上的数字分配到 正 号。
 * 剩余每位上数字的符号都与其相邻数字相反。
 * 返回所有数字及其对应符号的和。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/alternating-digit-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/12 13:55
 */
public class demo1 {
    public int alternateDigitSum(int n) {
        Integer a = new Integer(n);
        char[] chars = a.toString().toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i % 2 == 0) {
                sum += chars[i] - '0';
            } else {
                sum -= chars[i] - '0';
            }
        }

        return sum;
    }
}

