package day2023_06_13;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * <p>
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 * <p>
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-the-duplicate-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/6/13 16:48
 */
public class demo3 {
    //    举例： 数字4，按理来说小于等于4的数字只有1，2，3，4 数量为4，如果数量大于4的话，说明1234中肯定有重复元素，所以区间缩小到1-4.4也有可能重复，例如123444;
//          如果数量小于等于4的话，说明1234肯定没有重复的，区间缩小到右边，而且4肯定也不是重复元素，因为遍历时用了=4
    public int findDuplicate1(int[] nums) {
        int length = nums.length;
//        因为数组含有n+1个元素，从1开始.所以n+1= length， n = length -1
        int left = 1, right = length - 1;
        while (left < right) {
//            去中间的数
            int mid = (left + right) >>> 1;
//            统计所有小于等于中间数的数量
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
//            根据抽屉理论，如果没有重复元素的话，那么小于等于mid的数量应该 <=mid
            if (count > mid) {
//                说明数组中小于等于mid的数量大于mid，所以重复元素就在1到mid之间,即左边
                right = mid;
            } else {
//                说明数组中小于等于mid的数量小于等于mid，合理。所以重复元素就在mid之间,即右边
                left = mid + 1;
            }

        }
        return left;
    }

    public int findDuplicate(int[] nums) {
//      142题环形链表
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}

