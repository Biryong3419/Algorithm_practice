import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class BOJ1027 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nArr = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).mapToInt(i -> i).toArray();
        int m = Integer.parseInt(br.readLine());
        List<Integer> mList = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        HashMap<Integer, Integer> myHashMap = new HashMap<>();
        for(int e: mList) {
            myHashMap.put(e, 0);
        }

        for(int e: nArr) {
            Integer valTaken = myHashMap.get(e);
            if(valTaken != null) {
                myHashMap.put(e, valTaken + 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(myHashMap.get(mList.get(i)).toString());
            sb.append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
