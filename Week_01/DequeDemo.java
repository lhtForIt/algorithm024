import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author lianght1
 * @date 2021/1/31
 */
public class DequeDemo {

    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();

        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);

        String str = deque.getFirst();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.removeFirst());
        }

        System.out.println(deque);

    }



}
