package day2023_06_29;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
 * <p>
 * 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/monotone-increasing-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/6/29 13:35
 */
public class demo2 {
    public int monotoneIncreasingDigits(int n) {
//        从后往前比较，右边只要比左边小就将右边所有数字置为9，左边数字-1，然后继续往前比较
        char[] chars = String.valueOf(n).toCharArray();
        int length = chars.length;
//        设置变量记录需要变9的开始位置
        int index = length;
//        不要用i与i-1进行比较。用i 与 i+1进行比较可以比较到起始位置
        for (int i = length - 2; i >= 0; i--) {
//            直接用ascii码进行比较
//            如果前一项大于后一项的话，前一项-1
            if (chars[i] > chars[i + 1]) {
                chars[i]--;
//                更新需要变9的起始位置
                index = i + 1;
            }
        }
//        开始变9
        for (int i = index; i < length; i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(new String(chars));
    }
}

