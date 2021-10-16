import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class BOJ1764 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splitedArr = br.readLine().split(" ");

        int n = Integer.parseInt(splitedArr[0]);
        int m = Integer.parseInt(splitedArr[1]);

        HashMap<String, Integer> nHashMap = new HashMap<>();
        ArrayList<String> strList = new ArrayList<>();

        // 듣도 못한
        for(int i = 0; i < n; i ++) {
            String str = br.readLine();
            nHashMap.put(str, 0);
        }

        // result string
        StringBuilder sb = new StringBuilder();

        // 보도 못한
        for(int i = 0; i < m; i ++) {
            String str = br.readLine();
            if(nHashMap.get(str) != null) {
                strList.add(str);
            }
        }
        Collections.sort(strList);
        strList.forEach(d -> sb.append(d).append("\n"));
        System.out.println(strList.size());
        System.out.print(sb.toString().trim());
    }
}
