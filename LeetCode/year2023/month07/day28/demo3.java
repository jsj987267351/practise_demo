package month07.day28;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/7/28 13:31
 */
public class demo3 {
    public int singleNumber1(int[] nums) {
//        求出数组中每个二进制位上的和，相同的数字和一定是3的倍数，最后对3取余求和即可
        int[] temp = new int[32];
        for (int num : nums) {
            int help = 1;
//            对于数组中的每一个数，都对其从低位至高位用1进行与运算
//            如果不为0，代表该位也为1，那么该位置的总数就++
            for (int i = 31; i >= 0; i--) {
                if ((num & help) != 0) {
                    temp[i]++;
                }
                help = help << 1;
            }
        }
        int sum = 0;
//        最后从高位至低位进行求和即可，从高位至低位是因为这里每次都将结果左移，也就是右边补0，补的0的位置就是给下一个地位使用
        for (int i = 0; i < 32; i++) {
            sum = sum << 1;
            sum += temp[i] % 3;
        }
        return sum;
    }


    public int singleNumber(int[] nums) {
        int[] temp = new int[32];
        for (int num : nums) {
            for (int i = 31; i >= 0; i--) {
//                这里不在移动1的位置，而是直接移动num来与1比较
                temp[i] += num & 1;
                num = num >> 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            sum = sum << 1;
            sum += temp[i] % 3;
        }
        return sum;
    }
}

