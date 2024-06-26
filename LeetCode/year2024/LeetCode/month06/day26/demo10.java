package LeetCode.month06.day26;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/26 10:49
 */
public class demo10 {
    class AnimalShelf {
        Queue<Integer> dogs = new LinkedList<>();
        Queue<Integer> cats = new LinkedList<>();

        public AnimalShelf() {

        }

        public void enqueue(int[] animal) {
            if (animal[1] == 0) {
                cats.add(animal[0]);
            } else {
                dogs.add(animal[0]);
            }
        }

        public int[] dequeueAny() {
            if (dogs.isEmpty() && cats.isEmpty()) {
                return new int[]{-1, -1};
            }
            if (dogs.isEmpty()) {
                return new int[]{cats.poll(), 0};
            } else if (cats.isEmpty()) {
                return new int[]{dogs.poll(), 1};
            } else {
                return cats.peek() < dogs.peek() ? new int[]{cats.poll(), 0} : new int[]{dogs.poll(), 1};
            }
        }

        public int[] dequeueDog() {
            if (dogs.isEmpty()) return new int[]{-1, -1};
            return new int[]{dogs.poll(), 1};
        }

        public int[] dequeueCat() {
            if (cats.isEmpty()) return new int[]{-1, -1};
            return new int[]{cats.poll(), 0};
        }
    }

}

