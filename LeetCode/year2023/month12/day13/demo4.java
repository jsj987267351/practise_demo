package month12.day13;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/13 14:00
 */
public class demo4 {
    public int findString(String[] words, String s) {
        int left = 0, right = words.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            while (mid > left && words[mid].equals("")) mid--;
            if (words[mid].equals(s)) {
                return mid;
            } else if (words[mid].compareTo(s) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

