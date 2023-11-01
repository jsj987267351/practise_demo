package month11.day01;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/add-binary/?envType=list&envId=hliQiQFH
 * @date 2023/11/1 12:52
 */
public class demo1 {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int temp = 0, sum = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            sum = temp;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
            }
            res.append(sum % 2);
            temp = sum / 2;
        }
        if (temp > 0){
            res.append(temp);
        }
        return res.reverse().toString();
    }
}

