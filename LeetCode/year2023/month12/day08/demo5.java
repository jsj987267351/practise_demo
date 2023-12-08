package month12.day08;


import java.util.LinkedList;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/8 14:25
 */
public class demo5 {
    class AnimalShelf {
        LinkedList<Integer> dog;
        LinkedList<Integer> cat;

        public AnimalShelf() {
            dog = new LinkedList<>();
            cat = new LinkedList<>();
        }

        public void enqueue(int[] animal) {
            int kind = animal[1];
            if (kind == 0) {
                cat.addLast(animal[0]);
            } else {
                dog.addLast(animal[0]);
            }
        }

        public int[] dequeueAny() {
            if (dog.isEmpty() && cat.isEmpty()) {
                return new int[]{-1, -1};
            } else if (dog.isEmpty()) {
                return new int[]{cat.removeFirst(), 0};
            } else if (cat.isEmpty()) {
                return new int[]{dog.removeFirst(), 1};
            } else {
                return cat.getFirst() < dog.getFirst() ? new int[]{cat.removeFirst(), 0} : new int[]{dog.removeFirst(), 1};
            }
        }

        public int[] dequeueDog() {
            if (dog.isEmpty()){
                return new int[]{-1, -1};
            }
            return new int[]{dog.removeFirst(), 1};
        }

        public int[] dequeueCat() {
            if (cat.isEmpty()){
                return new int[]{-1, -1};
            }
            return new int[]{cat.removeFirst(), 0};
        }
    }
}

