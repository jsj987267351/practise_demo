package month12.day14;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/14 15:55
 */
public class demo1 {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return length;
        }
//        index 与 compare 永远相差2，代表当前插入的元素索引以及需要比较的元素索引
        int index = 2, compare = 0;
        for (int i = 2; i < length; i++) {
            if (nums[i] != nums[compare]) {
                nums[index] = nums[i];
                compare++;
                index++;
            }
        }
        return index;
    }
}

