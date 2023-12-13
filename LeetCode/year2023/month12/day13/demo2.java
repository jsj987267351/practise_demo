package month12.day13;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/13 13:43
 */
public class demo2 {
    public int cuttingBamboo(int bamboo_len) {
        if (bamboo_len < 4) {
            return bamboo_len - 1;
        }
        int count = bamboo_len / 3;
        int yu = bamboo_len % 3;
        if (yu == 1) {
            return (int) (Math.pow(3, count - 1) * 4);
        }
        if (yu == 2){
            return (int) (Math.pow(3,count)*2);
        }
        return (int) Math.pow(3,count);
    }
}

