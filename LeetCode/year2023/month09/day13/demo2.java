package month09.day13;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/9/13 13:09
 */
public class demo2 {
    class StreamRank {
        List<Integer> list;

        public StreamRank() {
            list = new ArrayList<>();
        }

        public void track(int x) {
//            添加元素的话通过二分查找找到插入索引，要保证数据有序
            list.add(findIndex(x), x);
        }

        public int getRankOfNumber(int x) {
//            索引前面的都是小于该数字的，所以直接索引即可
            return findIndex(x);
        }

        //        找到数组中第一个大于x的下标索引并返回
        public int findIndex(int x) {
            int left = 0, right = list.size() - 1;
            while (left <= right) {
                int mid = (left + right) >> 1;
//                等于要往右压缩区间，因为结果包括等于
                if (list.get(mid) <= x) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
//            返回的就是第一个大于x的下标索引
            return left;
        }
    }
}

