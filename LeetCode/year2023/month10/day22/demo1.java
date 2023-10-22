package month10.day22;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/22 11:44
 */
public class demo1 {
    public int maxSatisfaction(int[] satisfaction) {
//        看灵茶山的解析，将数组排序后倒序遍历
//        可以推论出f（k） = f(k-1) + k个菜的前缀和
        Arrays.sort(satisfaction);
        int len = satisfaction.length;
//        这里的cur就是前缀和 ，res每轮都会更新，所以每次到下一轮时，res就是f(k-1)
        int res = 0, cur = 0;
        for (int i = len - 1; i >= 0; i--) {
            cur += satisfaction[i];
            if (cur <= 0) break;
            res += cur;
        }
        return res;
    }
}

