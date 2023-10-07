package month10.day07;


import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/7 14:03
 */
public class demo2 {
//    暴力解法
    class StockSpanner {
        List<Integer> list;

        public StockSpanner() {
            list = new ArrayList<>();
        }

        public int next(int price) {
            int count = 0;
            list.add(price);
            for (int i = list.size() - 1; i >= 0 && list.get(i) <= price; i--) {
                count++;
            }
            return count;
        }
    }
}

