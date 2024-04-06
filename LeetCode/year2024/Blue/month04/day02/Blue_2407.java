package Blue.month04.day02;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/4/3 12:58
 */
public class Blue_2407 {
    public static void main(String[] args) {
//        转换为26进制
        StringBuilder res = new StringBuilder();
        int n = 2022;
        int cur = n / (26 * 26);
        res.append((char) (cur -1  + 'A'));
        n -= cur * (26 * 26);
        cur = n / 26;
        res.append((char) (cur -1  + 'A'));
        n -= cur * 26;
        cur = n % 26;
        res.append((char) (cur -1 + 'A'));
        System.out.println(res.toString());
    }
//    public static void main(String[] args) {
////        转换为26进制
//        StringBuilder res = new StringBuilder();
//        int n = 2022;
//        while (n > 0) {
//            res.append((char) (--n % 26 + 'A'));
//            n /= 26;
//        }
//        System.out.println(res.reverse().toString());
//    }
}

