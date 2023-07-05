package month06.day26;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/wiggle-subsequence/
 * @date 2023/6/26 14:50
 */
public class demo1 {
    public  int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int res = 1;
//        当前差值
        int cur = 0;
//        前一个差值
        int pre = 0;
        for (int i = 1; i <nums.length ; i++) {
//            当前差值
            cur = nums[i] - nums[i-1];
//            判断是否符合条件
            if (cur >0 && pre <=0 || cur<0 && pre >=0){
//                当前差值不包含0的情况，所以后续pre也不会存在0的情况。开始的>=0 和<=0是为了初始值
                res++;
                pre = cur;
            }
        }
        return res;
    }
}

