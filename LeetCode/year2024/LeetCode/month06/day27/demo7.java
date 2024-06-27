package LeetCode.month06.day27;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/27 10:54
 */
public class demo7 {
    public int[] sockCollocation(int[] sockets) {
        int a = 0;
        for (int socket : sockets) {
            a ^= socket;
        }
        int temp = 1;
        while ((temp & a) == 0) {
            temp <<= 1;
        }
        int res1 = 0,res2 = 0;
        for (int socket : sockets) {
            if ((socket & temp) == 0){
                res1 ^= socket;
            }else {
                res2 ^= socket;
            }
        }
        return new int[]{res1,res2};
    }
}

