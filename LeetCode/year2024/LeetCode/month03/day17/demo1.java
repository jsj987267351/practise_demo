package LeetCode.month03.day17;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/3/17 16:16
 */
public class demo1 {
    public String maximumOddBinaryNumber(String s) {
        int length = s.length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < length -1; i++) {
            if (i < count -1){
                res.append('1');
            }else {
                res.append('0');
            }
        }
        res.append('1');
        return res.toString();
    }
}

