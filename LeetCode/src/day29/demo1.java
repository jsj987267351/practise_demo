package day29;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * <p>
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 * <p>
 * 链接：https://leetcode.cn/problems/add-strings
 * @date 2023/4/20 17:45
 */
public class demo1 {
    public  String addStrings(String num1, String num2) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = num1.length()-1;
        int j = num2.length()-1;
        int temp = 0;
        while (i>=0 || j>=0){
            int n1 = 0;
            int n2 = 0;
            if (i >=0){
                 n1 = num1.charAt(i) - '0';
            }
            if (j >=0){
                 n2 = num2.charAt(j) - '0';
            }
            int sum = temp + n1 + n2;
            stringBuilder.append(sum%10);
            temp = sum /10;
            i--;
            j--;
        }
        if (temp ==1){
            stringBuilder.append(1);
        }
        return stringBuilder.reverse().toString();
    }

}

