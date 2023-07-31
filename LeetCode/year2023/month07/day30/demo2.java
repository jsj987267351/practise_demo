package month07.day30;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/30 13:16
 */
public class demo2 {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }
//        index表示当前符合要求的长度索引
//        初始前2个一定是符合要求的，所以index = 2
        int index = 2;
//        比较索引
        int help = 0;
//        每次比较索引与符合要求长度索引差值为2则一定满足要求
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[help]) {
                nums[index] = nums[i];
                index++;
                help++;
            }
        }
        return index;
    }
}

