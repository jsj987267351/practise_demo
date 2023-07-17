package month07.day17;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *
 * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。  
 *
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/17 17:59
 */
public class demo1 {
    public int minArray(int[] numbers) {
        int left = 0 , right = numbers.length-1;
        while (left < right){
            int mid = left + (right - left)/2;
            if (numbers[mid] < numbers[right]){
//                说明数组右边有序,也就是说最小值一定在当前值以及当前值左边
                right = mid;
            }else if (numbers[mid] > numbers[right]){
//                说明左边有序，也就是说最小值旋转到了右边去，并且当前值一定不是最小值
                left = mid+1;
            }else {
//                重复元素，当前值可能是最小值，所以最右边可以去重，因为与当前值相同，当前值还在查询范围内
                right-=1;
            }
        }
        return numbers[left];
    }
}

