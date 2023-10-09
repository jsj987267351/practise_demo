package month10.day09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/split-with-minimum-sum/description/?envType=daily-question&envId=2023-10-09
 * @date 2023/10/9 11:37
 */
public class demo1 {
    public int splitNum1(int num) {
        List<Integer> list = new ArrayList<>();
        while (num != 0) {
            list.add(num % 10);
            num = num / 10;
        }
        int num1 = 0, num2 = 0;
        list.sort((a, b) -> a - b);
        int index = 0;
        while (index < list.size()) {
            int temp1 = list.get(index);
            index++;
            num1 = num1 * 10 + temp1;
            if (index < list.size()) {
                int temp2 = list.get(index);
                index++;
                num2 = num2 * 10 + temp2;
            }
        }
        return num1 + num2;
    }

    public int splitNum(int num) {
//        排序后奇偶分组，与上次提交同理
        char[] chars = Integer.toString(num).toCharArray();
        Arrays.sort(chars);
        int[] res = new int[2];
        for (int i = 0; i < chars.length; i++) {
//            这样就可以奇偶分组
            res[i % 2] = res[i % 2] * 10 + (chars[i] - '0');
        }
        return res[0] + res[1];
    }
}

