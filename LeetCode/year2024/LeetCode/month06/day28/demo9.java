package LeetCode.month06.day28;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/28 10:52
 */
public class demo9 {
    class StreamRank {
        List<Integer> list;

        public StreamRank() {
            list = new ArrayList<>();
        }

        public void track(int x) {
            int index = findIndex(x);
            list.add(index,x);
        }

        public int getRankOfNumber(int x) {
            return findIndex(x);
        }

        public int findIndex(int num) {
            int left = 0, right = list.size() - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (list.get(mid) <= num) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }
}

