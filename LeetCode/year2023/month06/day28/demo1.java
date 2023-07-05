package month06.day28;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/6/28 14:12
 */
public class demo1 {
    public boolean lemonadeChange1(int[] bills) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
//                收5美元不用找零，直接收入
                map.put(5, map.getOrDefault(5, 0) + 1);
            } else if (bills[i] == 10) {
//                收10美元需要找零5美元
                map.put(10, map.getOrDefault(10, 0) + 1);
//                查看剩余5美元的数量
                Integer five = map.getOrDefault(5, 0);
                if (five == 0) {
                    return false;
                } else {
                    map.put(5, five - 1);
                }
            } else {
//                收20美元的话要找零15美元，即10+5 或5+5+5 优先10+5，因为5还可以用于10美元的找零
                Integer five = map.getOrDefault(5, 0);
                Integer ten = map.getOrDefault(10, 0);
//                20找零至少需要1个5美元
                if (five == 0) {
                    return false;
                }
                if (ten > 0) {
//                    优先10+5
                    map.put(10, ten - 1);
                    map.put(5, five - 1);
                } else if (ten == 0 && five >= 3) {
                    map.put(5, five - 3);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean lemonadeChange(int[] bills) {
//      直接使用变量记录美元数量即可
        int five = 0, ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else {
                if (five == 0) {
                    return false;
                }
                if (ten > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}

