package month07.day28;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/7/28 12:59
 */
public class demo2 {
    public int[] singleNumbers(int[] nums) {
        int sum = 0;
//        首先进行全体异或，最后的结果就是两个不同数字的异或结果
        for (int num : nums) {
            sum ^= num;
        }

//        根据两个不同数字的异或结果找到不同的那一位
        int temp = 1;
        while ((sum & temp) == 0) {
            temp = temp << 1;
        }
//        进行分组异或，因为不同的那一位我们已经找到了，所以这两个数字根据这一位进行异或肯定会分到不同的组
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & temp) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}

