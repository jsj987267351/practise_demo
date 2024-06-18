package LeetCode.month06.day18;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/18 10:44
 */
public class demo5 {
    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        int index = 0;
        while (index < 13) {
            if (num >= nums[index]) {
                num -= nums[index];
                res.append(romans[index]);
            } else {
                index++;
            }
        }
        return res.toString();
    }
}

