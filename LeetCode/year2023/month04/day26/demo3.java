package month04.day26;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * https://leetcode.cn/problems/integer-to-roman/
 * @date 2023/4/26 17:30
 */
public class demo3 {
    public String intToRoman1(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        int th = num / 1000;
        num = num % 1000;

        for (int i = 0; i < th; i++) {
            stringBuilder.append("M");
        }

        int hu = num / 100;
        if (hu > 8) {
            stringBuilder.append("CM");
            num = num % 900;
        } else if (hu > 4) {
            stringBuilder.append("D");
            num = num % 500;
        }else if (hu>3){
            stringBuilder.append("CD");
            num = num%400;
        }
        int hu2 = num / 100;
        num = num % 100;
        for (int i = 0; i < hu2; i++) {
            stringBuilder.append("C");
        }

        int ten = num / 10;
        if (ten>8){
            stringBuilder.append("XC");
            num = num%90;
        }else if (ten>4){
            stringBuilder.append("L");
            num = num%50;
        }else if (ten>3){
            stringBuilder.append("XL");
            num = num%40;
        }
        int ten2 = num/10;
        num = num%10;
        for (int i = 0; i < ten2; i++) {
            stringBuilder.append("X");
        }

        if (num>8){
            stringBuilder.append("IX");
            num = num%9;
        }else if (num>4){
            stringBuilder.append("V");
            num = num%5;
        }else if (num >3){
            stringBuilder.append("IV");
            num = num%4;
        }
        for (int i = 0; i < num; i++) {
            stringBuilder.append("I");
        }

        return stringBuilder.toString();
    }

    public String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int index = 0;
        while (index <13){
            while (num>=nums[index]){
                stringBuilder.append(romans[index]);
                num-=nums[index];
            }
            index++;
        }
        return stringBuilder.toString();
    }
}

