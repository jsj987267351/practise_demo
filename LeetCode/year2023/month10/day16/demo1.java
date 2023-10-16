package month10.day16;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/single-number-iii/description/?envType=daily-question&envId=2023-10-16
 * @date 2023/10/16 12:42
 */
public class demo1 {
    public int[] singleNumber(int[] nums) {
//      hash表解法这里不写了，直接遍历寻找即可
//      使用位运算，因为数组中所有数字除了那两个以外其余的全部出现两次，所以全部异或之后得到的结果就是答案的两个数字的异或结果
        int temp = 0;
        for (int num : nums) {
            temp ^= num;
        }
//        此时的temp就是答案的两个数字异或的结果，然后找到temp二进制中为1的一位，代表答案的两个数字的二进制在该位上不同
//        就可以将数组中的所有元素与该位进行与运算分组，这样答案的两个数字一定会分到两个不同的组内，其余出现两次的数字相同的一定会分到同一组
//        并且会因为数字相同而异或掉，最终异或完毕两组的最后一个数字就是答案

//        找到不同的一位，使用补码与孙算，得到的就是为1的那位
        int different = temp & (-temp);
        int res1 = 0, res2 = 0;
        for (int num : nums) {
//            分组
            if ((num & different) != 0) {
                res1 ^= num;
            } else {
                res2 ^= num;
            }
        }
        return new int[]{res1, res2};
    }
}

