package month10.day21;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/21 13:02
 */
public class demo5 {
    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strings = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int index = 0;
        while (index < 13) {
            if (num >= nums[index]) {
                res.append(strings[index]);
                num -= nums[index];
            } else {
                index++;
            }
        }
        return res.toString();
    }
}

