package month11.day13;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/13 12:18
 */
public class demo1 {
    class NumArray {
        int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public void update(int index, int val) {
            nums[index] = val;
        }

        public int sumRange(int left, int right) {
            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum += nums[i];
            }
            return sum;
        }
    }
}

