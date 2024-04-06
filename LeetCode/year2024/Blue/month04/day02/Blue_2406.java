package Blue.month04.day02;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/4/3 12:50
 */
public class Blue_2406 {
    public static void main(String[] args) {
        int start = 2023;
        while (true) {
            int cur = start;
            boolean flag = true;
            while (cur > 0) {
                int yu = cur % 16;
                if (yu < 10) {
                    flag = false;
                    break;
                }
                cur /= 16;
            }
           if (flag){
               System.out.println(start);
               break;
           }else {
               start++;
           }
        }
    }
}

