package LeetCode.month08.day09;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/8/9 11:17
 */
public class demo5 {
    public int garbageCollection(String[] garbage, int[] travel) {
        int MIndex = 0, GIndex = 0, PIndex = 0, res = 0;
        for (int i = 0; i < garbage.length; i++) {
            String cur = garbage[i];
            res += cur.length();
            for (int j = 0; j < cur.length(); j++) {
                if (cur.charAt(j) == 'M') {
                    MIndex = i;
                } else if (cur.charAt(j) == 'G') {
                    GIndex = i;
                } else if (cur.charAt(j) == 'P') {
                    PIndex = i;
                }
            }
        }
        for (int i = 1; i < travel.length; i++) {
            travel[i] = travel[i] + travel[i - 1];
        }
        res += MIndex > 0 ? travel[MIndex - 1] : 0;
        res += GIndex > 0 ? travel[GIndex - 1] : 0;
        res += PIndex > 0 ? travel[PIndex - 1] : 0;
        return res;
    }
}

