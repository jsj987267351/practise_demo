package month10.day23;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/23 11:46
 */
public class demo1 {
    public int countSeniors(String[] details) {
        int res = 0;
        for (String detail : details) {
            int age = Integer.parseInt(detail.substring(11, 13));
            if (age > 60) res++;
        }
        return res;
    }
}

