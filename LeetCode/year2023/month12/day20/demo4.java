package month12.day20;

import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/20 15:01
 */
public class demo4 {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        help(A.size(), A, B, C);
    }

    public void help(int size, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (size == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        }
        help(size - 1, A, C, B);
        C.add(A.remove(A.size() - 1));
        help(size - 1, B, A, C);
    }
}

