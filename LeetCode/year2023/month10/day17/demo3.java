package month10.day17;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/can-place-flowers/?envType=list&envId=hliQiQFH
 * @date 2023/10/17 12:24
 */
public class demo3 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        int length = flowerbed.length;
        for (int i = 0; i < length; ) {
            if (flowerbed[i] == 1) {
                i += 2;
            } else if (i == length - 1 || flowerbed[i + 1] == 0) {
                n--;
                if (n == 0) {
                    return true;
                }
                i += 2;
            } else {
                i += 3;
            }
        }
        return false;
    }
}

