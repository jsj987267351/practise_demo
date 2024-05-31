package LeetCode.month05.day31;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/5/31 13:59
 */
public class demo13 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        for (int i = 0; i < flowerbed.length; ) {
            if (flowerbed[i] == 1) {
                i += 2;
            } else if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
                n--;
                if (n == 0) return true;
                i += 2;
            } else {
                i += 3;
            }
        }
        return false;
    }
}

