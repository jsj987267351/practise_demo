package LeetCode.month07.day03;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/3 9:21
 */
public class demo1 {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int temp = x, sum = 0;
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        return x % sum == 0 ? sum : -1;
    }
}

