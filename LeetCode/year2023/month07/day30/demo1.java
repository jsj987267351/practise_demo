package month07.day30;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/7/30 12:29
 */
public class demo1 {
    public int lastRemaining(int n, int m) {
        int res = 0;
//        每次删除的元素放在删除后的队列的最后然后右移m个，将溢出的移到队头就变成了删之前的队列（下标也跟着移动）
//        根据这个规则从删到只剩最后一个元素，下标为0，不断增加元素恢复到初始状态下标就是答案
        for (int i = 2; i <= n; i++) {
            res = (res + m) % i;
        }
        return res;
    }


//    public int lastRemaining(int n, int m) {
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            list.add(i);
//        }
//
//        int index = 0;
//        int count = 1;
//        while (list.size() > 1) {
//            if (index == list.size()){
//                index = 0;
//            }
//            if (count == m){
//                list.remove(index);
//                index--;
//                count = 0;
//            }
//            index++;
//            count++;
//        }
//        return list.get(0);
//    }
}

