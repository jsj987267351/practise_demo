package month12.day11;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/11 13:17
 */
public class demo3 {
    public  int multiply(int A, int B) {
        if (A < B) {
            return multiply(B, A);
        }
        int temp = A;
        while (B > 1) {
            A += temp;
            B--;
        }
        return A;
    }
}

