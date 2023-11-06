package month11.day05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/5 12:18
 */
public class demo9 {
    public List<String> findRepeatedDnaSequences(String s) {
//        哈希表，从头遍历字符串中所有连续长度为10的字符串并记录出现次数，在遍历过程中统计出现2次的字符串即可，因为出现多次的话一定会到达两次，后面在出现到3次的时候不会符合判断条件，就不会重复
        int length = s.length();
        List<String> res = new ArrayList<>();
        if (length < 10) {
            return res;
        }
        Map<String, Integer> map = new HashMap<>();
        int left = 0, right = 10;
        while (right < length + 1) {
            String temp = s.substring(left, right);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            if (map.get(temp) == 2){
                res.add(temp);
            }
            left++;
            right++;
        }
        return res;
    }
}

