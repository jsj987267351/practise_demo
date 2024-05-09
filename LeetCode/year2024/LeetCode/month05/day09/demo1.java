package LeetCode.month05.day09;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/5/9 12:00
 */
public class demo1 {
    public int wateringPlants(int[] plants, int capacity) {
        int res = 0, cur = capacity;
        for (int i = 0; i < plants.length; ) {
            if (plants[i] <= cur) {
                res++;
                cur -= plants[i];
                i++;
            } else {
                res += (i * 2);
                cur = capacity;
            }
        }
        return res;
    }
}

