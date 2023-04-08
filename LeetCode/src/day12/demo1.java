package day12;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ResultTreeType;

import java.util.UUID;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组
 * @date 2023/3/30 11:24
 * https://leetcode.cn/problems/remove-element/
 */
public class demo1 {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        int result = nums.length;
        int i = 0;
        int j = nums.length-1;
        int temp = 0;
        while (i <= j) {
            if(nums[i] == val && nums[j] ==val){
                j--;
                result--;
            }else if (nums[i] ==val && nums[j]!=val){
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                result--;
                i++;
                j--;
            }else if (nums[i]!=val && nums[j] ==val){
                result--;
                i++;
                j--;
            }else {
                i++;
            }
        }
        return result ;
    }
}

