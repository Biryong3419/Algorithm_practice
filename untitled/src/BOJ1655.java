import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        for(int i = count; i > 0; i--) {
            int m = Integer.parseInt(br.readLine());
            if(maxHeap.size() == minHeap.size()) {
                maxHeap.offer(m);
            } else {
                minHeap.offer(m);
            }
            if(maxHeap.size() > 0 && minHeap.size() > 0) {
                if(maxHeap.peek() > minHeap.peek()) {
                    int tmp = minHeap.poll();
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(tmp);
                }
            }
           sb.append(maxHeap.peek()).append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}
