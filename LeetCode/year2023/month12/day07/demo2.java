package month12.day07;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/7 13:48
 */
public class demo2 {
    public boolean verifyTreeOrder(int[] postorder) {
        if (postorder.length < 3) {
            return true;
        }
//        左右中
        return help(postorder, 0, postorder.length - 1);
    }

    public boolean help(int[] postorder, int left, int right) {
        if (left >= right) {
            return true;
        }
        int rootValue = postorder[right];
        int p = left;
        while (postorder[p] < rootValue) {
            p++;
        }
        int m = p;
        while (postorder[p] > rootValue) {
            p++;
        }
        return p == right && help(postorder, left, m - 1) && help(postorder, m, right - 1);
    }
}

