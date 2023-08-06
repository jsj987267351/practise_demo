package month08.day06;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个  无重复元素 的 有序 整数数组 nums 。
 * <p>
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * <p>
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/summary-ranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/8/6 14:20
 */
public class demo3 {
    public List<String> summaryRanges(int[] nums) {
//        只要连续就放一起，不连续就单独拿出来
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            if (!(i + 1 < length && nums[i] == nums[i + 1] - 1)) {
//                不符合要求的，将当前值加入后就直接截止，并且加入最终集合，当前值就是当前连续序列的最后一个数字
                if (sb.length() > 0) {
//                    如果前面已经有数字了，要加上箭头，因为说明这是一个连续的序列，并且序列头部已经加入了进去，否则没有数字的话直接加上数字截胡即可
                    sb.append("->");
                }
                sb.append(nums[i]);
                res.add(sb.toString());
//                并且数组要清空
                sb = new StringBuilder();
            } else {
//                符合连续的
                if (sb.length() == 0) {
//                    如果当前数字是第一个数字才加上,因为箭头只包括这个集合的开头与结尾的数字，如果不等于0的话，说明这个连续序列的开头已经加上了
                    sb.append(nums[i]);
                }
            }
        }
        return res;
    }
}

