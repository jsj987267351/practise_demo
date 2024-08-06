package LeetCode.month08.day06;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/8/6 9:31
 */
public class demo1 {
    public String maximumBinaryString(String binary) {
        int start = binary.indexOf('0');
        if (start < 0) return binary;
        int count = 0;
        for (; start < binary.length(); start++) {
            if (binary.charAt(start) == '1') {
                count++;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < binary.length() - 1 - count; i++) {
            res.append('1');
        }
        res.append('0');
        for (int i = binary.length() - count; i < binary.length(); i++) {
            res.append('1');
        }
        return res.toString();
    }
}

