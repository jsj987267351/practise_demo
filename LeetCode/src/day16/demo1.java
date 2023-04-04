package day16;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * @date 2023/4/4 12:06
 */
public class demo1 {
    public void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i <= j; i++, j--) {
            char temp;
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}

