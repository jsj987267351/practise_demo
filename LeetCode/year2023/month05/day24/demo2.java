package month05.day24;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1
 * https://leetcode.cn/problems/number-of-steps-to-reduce-a-number-to-zero/
 * @date 2023/5/24 16:29
 */
public class demo2 {
    public int numberOfSteps(int num) {
        int sum = 0;
        while (num != 0) {
            if (num % 2 == 0) {
//                偶数
                num /= 2;
            } else {
                num -= 1;
            }
            sum++;
        }
        return sum;
    }
}

