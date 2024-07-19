package LeetCode.month07.day19;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/19 10:12
 */
public class demo5 {
    public int maximumSwap(int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        int len = charArray.length;
        for (int i = 0; i < len; i++) {
            int maxIndex = i;
            for (int j = len - 1; j > i; j--) {
                if (charArray[j] > charArray[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex!=i){
                char temp = charArray[i];
                charArray[i] = charArray[maxIndex];
                charArray[maxIndex] = temp;
                return Integer.parseInt(new String(charArray));
            }
        }
        return num;
    }
}

