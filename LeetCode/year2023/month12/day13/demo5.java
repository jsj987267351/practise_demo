package month12.day13;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/13 14:08
 */
public class demo5 {
    class StreamRank {
        List<Integer> list;

        public StreamRank() {
            list = new ArrayList<>();
        }

        public void track(int x) {
            list.add(findIndex(x), x);
        }

        public int getRankOfNumber(int x) {
            return findIndex(x);
        }

        public int findIndex(int x) {
            int left = 0, right = list.size() - 1;
            while (left <= right) {
                int mid = (left + right) >> 1;
                if (list.get(mid) <= x) {
                    left = mid + 1;
                } else {
                    right = mid -1 ;
                }
            }
            return left;
        }
    }
}

