package month07.day29;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/jian-sheng-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/29 11:57
 */
public class demo2 {
    public int cuttingRope(int n) {
//        数学问题：最大乘机要求切分为相同的数字最大，每段分成3最大，证明看题解
//        绳子长度最大为3时单独最大乘机就是切出来一个1，因为最少要切1段
        if (n < 4) {
            return n - 1;
        }
//        绳子按3划分最多可以分几段
        int duan = n / 3;
//        按3划分的话最后一段的长度
        int last = n % 3;
        if (last == 1) {
//            如果最后一段为1的话，就将最后一段与前一段放在一起
//            也就是少了一个3段，然后最后一段变为4
            return (int) Math.pow(3, duan - 1) * 4;
        }
        if (last == 2) {
//            最后一段为2，最后两端如果单独乘就是3*2=6，如果和一起就是2+3=5，所以单独拿出来乘更大
            return (int) Math.pow(3, duan) * 2;
        }
//        否则就是刚好分段
        return (int) Math.pow(3, duan);
    }
}

