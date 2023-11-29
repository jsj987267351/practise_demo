package month11.day29;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/29 16:49
 */
public class demo1 {
    class SmallestInfiniteSet {
        boolean[] exist;
        int smallIndex;

        public SmallestInfiniteSet() {
//            true代表已经被删除，false代表还未被删除
            exist = new boolean[1001];
//            代表要删除的索引的最小值
            smallIndex = 1;
        }

        public int popSmallest() {
//            有可能删除又添加导致不连续，所以要找到未删除的第一个数字
            while (exist[smallIndex]){
                smallIndex++;
            }
            exist[smallIndex] = true;
            return smallIndex;
        }

        public void addBack(int num) {
            if (exist[num]) {
                exist[num] = false;
            }
            smallIndex = Math.min(smallIndex, num);
        }
    }
}

