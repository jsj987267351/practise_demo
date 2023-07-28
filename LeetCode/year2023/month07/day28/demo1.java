package month07.day28;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/7/28 12:28
 */
public class demo1 {
    public int add(int a, int b) {
//        看 陆艰步走 这个用户的解析
//        异或代表+操作，与代表进位操作，结果为（a ^ b） + ((a & b)<<1) 即异或和与运算的和，将运算符两边看作整体不断运算
        while (b != 0) {
//            与运算然后左移一位求出进位
            int temp = (a & b) << 1;
//            异或求出加法
            a = a ^ b;
//            不断循环赋值
            b = temp;
        }
        return a;
    }
}

