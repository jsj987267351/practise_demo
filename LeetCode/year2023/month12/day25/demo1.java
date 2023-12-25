package month12.day25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/25 13:47
 */
public class demo1 {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
//        鸡兔同笼
        List<Integer> res = new ArrayList<>();
        if (tomatoSlices % 2 != 0 || tomatoSlices < cheeseSlices * 2 || tomatoSlices > 4 * cheeseSlices) {
            return res;
        }
        int bigNum = tomatoSlices / 2 - cheeseSlices;
        int smallNum = 2 * cheeseSlices - tomatoSlices / 2;
        res.add(bigNum);
        res.add(smallNum);
        return res;
    }
}

