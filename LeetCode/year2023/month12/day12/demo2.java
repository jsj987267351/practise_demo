package month12.day12;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/12 14:00
 */
public class demo2 {
    public int[] sockCollocation(int[] sockets) {
        int sum = 0;
        for (int i = 0; i < sockets.length; i++) {
            sum ^= sockets[i];
        }
        int temp = 1;
        while ((temp & sum) == 0) {
            temp <<= 1;
        }
        int a = 0, b = 0;
        for (int i = 0; i < sockets.length; i++) {
            if ((sockets[i] & temp) == 0) {
                a ^= sockets[i];
            } else {
                b ^= sockets[i];
            }
        }
        return new int[]{a, b};
    }
}

