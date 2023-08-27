package month08.day27;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/8/27 13:08
 */
public class demo3 {
    public static boolean oneEditAway(String first, String second) {
        int longer = first.length();
        int shorter = second.length();
//        特判
        if (Math.abs(longer - shorter) > 1) {
            return false;
        }
//       始终让longer 代表长的字符串的长度,并且始终让first代表长的，shorter代表短的字符串的长度，让second代表短的
        if (longer < shorter) {
            return oneEditAway(second, first);
        }
//        res代表操作次数，i 代表长的索引，j代表短的遍历索引
        int i = 0, j = 0, res = 0;
//        剪枝，当操作次数大于1直接循环中止即可
        while (i < longer && j < shorter && res <= 1) {
            if (first.charAt(i) == second.charAt(j)) {
//                如果相等都继续往后遍历
                i++;
                j++;
            } else {
                if (longer == shorter) {
//                    如果不相等的话，如果两个字符串长度相等，代表只能通过更改，所以都往后遍历
                    i++;
                    j++;
                } else {
//                    不相等的话，只能通过增加或者删除,长的删除等于短的增加，这里让长的往后移
                    i++;
                }
//                增删改都算操作一次，操作数+1
                res++;
            }
        }
//        判断操作次数是否大于1
        return res <= 1;
    }

    public static void main(String[] args) {
        boolean b = oneEditAway("islander", "slander");
        System.out.println(b);
    }
}

