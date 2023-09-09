package month09.day09;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/9/9 13:44
 */
public class demo1 {
    public int multiply(int A, int B) {
        return help(Math.max(A, B), Math.min(A, B), 0);
    }

    public int help(int max, int min, int res) {
        return min > 0 ? help(max, min - 1, res + max) : res;
    }
}

