import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
        p.add(10);
        p.add(30);
        p.add(400);
        p.add(5);
        p.add(347);
        // top element 출력, 큐 비어있다면 null 반환
        System.out.println(p.peek()); // 400 , max heap
        // 큐가 비어있다면 예외 발생
        p.element();

        // top element 반환하고, remove 한다, 큐가 비어있다면 null을 반환한다.
        System.out.println(p.poll());
        // remove 하는데, 큐가 비어있으면 예외 발생한다.
        p.remove();

        // add, offer 모두 삽입이다
        p.add(3);
        p.offer(1);


        p.isEmpty();
    }
}
