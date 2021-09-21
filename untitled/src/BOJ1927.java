import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1927 {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        for(int i = count; i > 0; i--) {
            int m = Integer.parseInt(br.readLine());
            if(m == 0) {
                pollAndPrint();
            } else {
                pq.offer(m);
            }
            //
        }
    }
    static void pollAndPrint() {
        Integer pickVal = pq.poll();
        if(pickVal != null) {
            System.out.println(pickVal);
        } else{
            System.out.println(0);
        }
    }
}
