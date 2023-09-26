package month09.day26;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/longest-increasing-subsequence/description/
 * @date 2023/9/26 12:10
 */
public class demo1 {
    public int lengthOfLIS(int[] nums) {
        int res = 0;
        for (int num : nums) {
//            用二分找到当前下标值以前的单调递增数组中的插入位置
            int index = binarySearch(nums, res, num);
//            更新插入的值，因为是更新，所以数组长度不变
            nums[index] = num;
//            如果更新的是最后的值，代表是直接在数组尾部添加操作，数组长度要++
            if (index == res){
                res++;
            }
        }
        return res;
    }

    public int binarySearch(int[] nums, int right, int value) {
//        使用开区间写法（left,right）,找到第一个大于等于value的元素的下标
        int left = -1;
//        表示left和right之间没有值了，成为了相邻的元素时停止
        while (left + 1 < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < value) {
//                在右边，所以left一定是小于value的元素下标
                left = mid;
            } else {
//                等于的时候也向左走，因为要等于也在我们的搜索范围内
                right = mid;
            }
        }
//        right就是第一个大于等于value的元素的下标
        return right;
    }
}

