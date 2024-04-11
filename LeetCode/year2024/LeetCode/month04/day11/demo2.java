package LeetCode.month04.day11;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/4/11 11:47
 */
public class demo2 {
    public String maximumBinaryString(String binary) {
//        具体看灵神解析
//        首先答案中一定不会出现大于1个0，因为如果出现大于1个0，都能通过操作2将这些0聚在1起，然后使用操作1将0的数量置为1
//        又因为只有操作2是能够移动0，并且只能左移，需要把所有的0左移聚在一起，然后通过操作1替换就是最终的最大值
//        所以最终结果中只会有1个0，需要确定的就是这个0的位置即可，最左边的全为1的肯定是不能动的，因为已经是最大值了
//        所以需要移动第一个0之后的所有1都移动到最右边，然后将所有0聚集在中间使用操作1替换后就是最大值了
//        所以最终结果中是（n - 1 - count）个1 + 1个0 + （count）个1，其中count就是移动第一个0之后的所有1都移动到最右边的数量
        int first = binary.indexOf('0');
        if (first < 0) {
//            说明全是1，已经是最大值
            return binary;
        }
//        统计第一个0之后有多少个1
        first++;
        int count = 0;
        char[] chars = binary.toCharArray();
        for (; first < chars.length; first++) {
            if (chars[first] == '1') {
                count++;
            }
        }
//        开始拼接
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < chars.length - 1 - count; i++) {
            res.append('1');
        }
        res.append('0');
        for (int i = 0; i < count; i++) {
            res.append('1');
        }
        return res.toString();
    }
}

