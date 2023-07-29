package month07.day29;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/gou-jian-cheng-ji-shu-zu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/29 11:45
 */
public class demo1 {
    public int[] constructArr(int[] a) {
        int length = a.length;
        if (a.length < 1) {
            return a;
        }
//        用两个数组求出每个下标对应的左右乘机最后对应相乘即可
        int[] left = new int[length];
        int[] right = new int[length];
        left[0] = 1;
        for (int i = 1; i < length; i++) {
            left[i] = a[i - 1] * left[i - 1];
        }
        right[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }
        for (int i = 0; i < length; i++) {
            a[i] = left[i] * right[i];
        }
        return a;
    }
}

