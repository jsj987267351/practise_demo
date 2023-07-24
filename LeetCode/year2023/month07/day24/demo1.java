package month07.day24;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 * @date 2023/7/24 12:46
 */
public class demo1 {
    public int reversePairs(int[] nums) {
//       解题思路：使用归并排序，每次归并排序时计算当前归并的数组中的逆序对
        int len = nums.length;
//      特判
        if (len < 2) {
            return 0;
        }
//        拷贝当前数组是为了不改变原先数组，当然如果可以改变的话可以直接将原数组当参数传递
        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }
//        定义归并时用的临时数组
        int[] temp = new int[len];

//        返回[0,len-1]内的所有逆序对
        return reversePairs(copy, 0, len - 1, temp);
    }

    private int reversePairs(int[] nums, int left, int right, int[] temp) {
//        如果当前数组中只有一个元素当然就没有逆序对了，返回0
        if (left == right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
//        递归求左右数组中存在的逆序对
        int leftNums = reversePairs(nums, left, mid, temp);
        int rightNums = reversePairs(nums, mid + 1, right, temp);
//        如果左边的最大元素小于右边的最小元素，那么当前数组归并过程中就一定不包含逆序对了，可以直接返回左右中的即可
//        因为计算逆序对时是右边数组每次放上去时，总数加上左边数组剩余的元素数目，当前情况右边放上去时左边元素一定都为0，所以直接返回即可
//        这里之所以可以直接mid+1不担心越界是因为 在计算mid时是向下取整，所以最多只能落到left
        if (nums[mid] < nums[mid + 1]) {
            return leftNums + rightNums;
        }

//        计算当前数组归并时有的逆序对数目
        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
//        返回左右归并中的逆序对以及当前归并中的逆序对
        return leftNums + rightNums + crossPairs;
    }

    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
//        复制到临时数组，将临时数组用来当分开的左右数组
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
//        总数
        int count = 0;
//        左数组的指针
        int i = left;
//        右数组的指针
        int j = mid + 1;

        for (int k = left; k <= right; k++) {
//            如果左边数组已经遍历完了，那么直接将右边数组放上去即可，也不会产生逆序对
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
//            如果右边数组已经遍历完了，那么直接将左边数组放上去即可，也不会产生逆序对
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
//                左边放上去不会产生逆序对，需要注意的是判断条件加上等号：因为等于时也不是逆序对，所以让左边放上去
                nums[k] = temp[i];
                i++;
            } else {
//                每次右边放上去时，就会产生逆序对，逆序对数量等于左边数组剩余元素的数量
                nums[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }
}

