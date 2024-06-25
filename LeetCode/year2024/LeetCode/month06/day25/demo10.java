package LeetCode.month06.day25;

import java.security.Key;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/25 11:27
 */
public class demo10 {
//    public boolean verifyTreeOrder(int[] postorder) {
//        if (postorder.length < 3) return true;
//        return isValid(postorder, 0, postorder.length - 1);
//    }
//
//    public boolean isValid(int[] postorder, int left, int right) {
//        if (left >= right) return true;
//        int value = postorder[right];
//        int index = left;
//        while (postorder[index] < value) {
//            index++;
//        }
//        int m = index;
//        while (postorder[index] > value) {
//            index++;
//        }
//        return index == right && isValid(postorder, left, index - 1) && isValid(postorder, index, right - 1);
//    }

    public boolean verifyTreeOrder(int[] postorder) {
        if (postorder.length < 3) return true;
        return isValid(postorder, 0, postorder.length - 1);
    }

    public boolean isValid(int[] postorder, int left, int right) {
        if (left >= right) return true;
        int mid = postorder[right];
        int index = findIndex(postorder, mid, left);
        for (int i = left; i < index; i++) {
            if (postorder[i] > mid) return false;
        }
        for (int i = index; i < right; i++) {
            if (postorder[i] < mid) return false;
        }
        return isValid(postorder, left, index - 1) && isValid(postorder, index, right - 1);
    }

    public int findIndex(int[] postorder, int val, int left) {
       while (postorder[left] < val){
           left++;
       }
       return left;
    }
}

