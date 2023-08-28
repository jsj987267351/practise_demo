package month08.day28;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/8/28 13:29
 */
public class demo3 {
    public boolean isFlipedString(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m != n) {
            return false;
        }
//        两个字符串相等并且可以通过旋转得来的话，直接将S1复制一倍，理解为旋转360
//        那么S2如果可以通过S1旋转得来那么一定是S1两倍的子集
        String s = s1 + s1;
        return s.contains(s2);
    }
}

