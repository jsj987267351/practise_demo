package LeetCode.month06.day16;

import com.sun.org.apache.xerces.internal.impl.dv.util.ByteListImpl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/16 14:35
 */
public class demo5 {
    public List<Long> maximumEvenSplit(long finalSum) {
        LinkedList<Long> res = new LinkedList<>();
        if (finalSum % 2 != 0 || finalSum < 2) return res;
        long cur = 2L;
        while (finalSum >= cur) {
            res.addLast(cur);
            finalSum-=cur;
            cur += 2;
        }
        if (finalSum != 0){
            Long last = res.removeLast();
            res.add(last + finalSum);
        }
        return new ArrayList<>(res);
    }
}

