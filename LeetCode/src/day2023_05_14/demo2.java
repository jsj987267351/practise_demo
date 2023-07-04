package day2023_05_14;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 链接：https://leetcode.cn/problems/kth-largest-element-in-an-array
 * @date 2023/5/14 18:33
 */
public class demo2 {

    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.add(num);
            if (heap.size() >k){
                heap.poll();
            }
        }
        return heap.peek();
    }


    public void quickSort(int[] nums,int left,int right ){
        int i = left ,j = right;
        if (left <right){

            int temp= nums[i];
            while (i <j){
                while (i<j && nums[j]>temp) j--;
                if (i<j){
                    nums[i] = nums[j];
                    i++;
                }
                while (i<j&& nums[i] <temp) i++;
                if (i<j){
                    nums[j] = nums[i];
                    j--;
                }
            }
            nums[i] = temp;
            quickSort(nums,0,i-1);
            quickSort(nums,i+1,right);
        }
    }

}

