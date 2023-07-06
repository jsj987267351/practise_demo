package month07.day06;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/7/6 13:54
 */
public class demo3 {
    public int findLength(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

//        dp[i][j]代表含义：数组nums1以i-1为结尾  和数组nums2以j-1为结尾的最长重复子数组
        int[][] dp = new int[length1 + 1][length2 + 1];
        int max = 0;

//        数组初始化： 刚开始dp[i][0]和dp[0][j]要初始化为0，因为是非法下标，并且后续根据动态需要+1
//        其他初始化为0，创建默认数组为0，所以可以直接创建即可

//        这里从1开始遍历是因为我们第一行和第一列都已经初始化好了
//        遍历结束条件选择==，是因为我们数组创建容量+1，并且定义是以-1结尾
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
//                如果两个元素相等，就查看其前一个元素是否相等，在前一个元素的连续基础上+1
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
}

