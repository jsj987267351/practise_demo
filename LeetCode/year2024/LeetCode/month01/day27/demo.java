package LeetCode.month01.day27;

import java.util.Collections;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/27 11:48
 */
public class demo {
    //    对每个器械使用二分查找找出当前器械最多能生产多少合金,之所以能二分遍历是因为对于生产合金数量是有序的，生产合金越多需要用料就越多，反之越少
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> Composition, List<Integer> Stock, List<Integer> Cost) {
        int res = 0;
//       能生产的最大数量，假设composition[i][j] 和 cost[j]都是 1，此时可以制造最多的合金，个数为min(Stock) + budget，也就是只差一种金属不满足，并且当前金属的需要最少为1，售价也为最少1时可以生产最多合金
        int max = Collections.min(Stock) + budget;
        int[] stock = Stock.stream().mapToInt(i -> i).toArray();
        int[] cost = Cost.stream().mapToInt(i -> i).toArray();
        for (List<Integer> Comp : Composition) {
//            当前机器
            int[] composition = Comp.stream().mapToInt(i -> i).toArray();
//            闭区间写法
            int left = res + 1, right = max;
            while (left <= right) {
                int mid = left + (right - left) / 2;
//              创造mid数量合金总共还需要花多少钱
                long money = 0;
//               能否生产出来mid合金数量
                boolean flag = true;
                for (int i = 0; i < n; i++) {
//                    计算每种金属数量是否足够，不足够的话就购买需要的金属
                    long need = (long) composition[i] * mid;
                    if (need > stock[i]) {
                        money += (need - stock[i]) * cost[i];
//                    超出预算的话直接无法生产出当前数量的合金
                        if (money > budget) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) {
//                    生产的出，更新最大值
                    left = mid + 1;
                } else {
//                    生产不出
                    right = mid - 1;
                }
            }
//            更新最大值
            res = right;
        }
        return res;
    }
}

