package month10.day20;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/20 11:53
 */
public class demo1 {
    public String categorizeBox(int length, int width, int height, int mass) {
        long max = Math.max(length, Math.max(width, height)), tiji = 1L * length * width * height;
        boolean isBulky = max >= 10000 || tiji >= 1000000000;
        boolean isHeavy = mass >= 100;
        if (isBulky && isHeavy) {
            return "Both";
        } else if (isBulky) {
            return "Bulky";
        } else if (isHeavy) {
            return "Heavy";
        } else {
            return "Neither";
        }
    }
}

