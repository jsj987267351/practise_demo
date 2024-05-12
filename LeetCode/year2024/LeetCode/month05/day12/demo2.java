package LeetCode.month05.day12;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/5/12 10:57
 */
public class demo2 {
    public int garbageCollection(String[] garbage, int[] travel) {
        int len = garbage.length;
        int res = 0, M = 0, G = 0, P = 0;
        for (int i = 0; i < len; i++) {
            String cur = garbage[i];
//            当前这个垃圾串回收完
            res += cur.length();
            for (int j = 0; j < cur.length(); j++) {
                char temp = cur.charAt(j);
                if (temp == 'G') {
                    G = i;
                } else if (temp == 'P') {
                    P = i;
                } else {
                    M = i;
                }
            }
        }
//       将原数组改为前缀和
        for (int i = 1; i < travel.length; i++) {
            travel[i] = travel[i] + travel[i - 1];
        }
        res += M > 0 ? travel[M - 1] : 0;
        res += G > 0 ? travel[G - 1] : 0;
        res += P > 0 ? travel[P - 1] : 0;
        return res;
    }
}

