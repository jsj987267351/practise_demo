package month09.day12;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/9/12 12:18
 */
public class demo2 {
    public int findString1(String[] words, String s) {
//         暴力解法
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(s)) {
                return i;
            }
        }
        return -1;
    }

    public int findString(String[] words, String s) {
//        二分查找，遇到空字符串往左，一直移到非空字符串在比较，后续正常二分
        int left = 0, right = words.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
//           先移动到非空字符串
//            这里只能往左移是因为，如果往右移的话，一种特殊情况为mid到right全是空字符串，那么就会一直移到末尾，判断后会 left = mid + 1 ，就会退出循环，但是结果可能在mid左面
//            而往左移，如果left到mid全是空字符串，判断后 left = mid + 1 仍然可以后续判断
//            所以往右移需要特判mid是否为空字符串，为空的话要让他 right = mid - 1
            while (mid > left && words[mid].equals("")) mid--;
            if (s.equals(words[mid])) {
                return mid;
            }
//            if (s.compareTo(words[mid]) < 0 || words[mid].equals(""))   往右移需要加这个条件
            if (s.compareTo(words[mid]) < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}

