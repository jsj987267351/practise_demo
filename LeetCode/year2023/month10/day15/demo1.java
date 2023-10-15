package month10.day15;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/single-number-ii/description/?envType=daily-question&envId=2023-10-15
 * @date 2023/10/15 13:32
 */
public class demo1 {
    public int singleNumber(int[] nums) {
//        将每个数组看作二进制，数组res保存每个数字的每一位出现的总数，最后每个数字对三取余就是出现一次的数字的二进制
        int[] res = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
//                索引小的存低位数量
                if ((num & 1) == 1) {
                    res[i]++;
                }
                num = num >> 1;
            }
        }
        int ans = 0;
//        自己模拟看出移位数量
        for (int i = 0; i < 32; i++) {
            if ((res[i] % 3 & 1) == 1) {
                ans += (1 << i);
            }
        }
        return ans;
    }
}

