import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result44 {

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    // not clear, on hold

    public static int nonDivisibleSubset(int k, List<Integer> s) {

        int[] arr = new int[s.size()];
        boolean[] visited = new boolean[s.size()];
        for(int i = 0; i < s.size(); i++) {
            arr[i] = s.get(i);
        }
        HashSet<Integer> mySet = new HashSet<>();

        combination(arr, visited, 0, s.size(), 2);
        for(int[] arr1 : combResultList) {
            int sum = arr1[0] + arr1[1];
            if(sum%k > 0) {
                mySet.add(arr1[0]);
                mySet.add(arr1[1]);
            } else {

            }
        }
        System.out.println((s.get(4) + s.get(5))%6);
        System.out.println(mySet.size());
        return mySet.size();
    }
    static List<int[]> combResultList = new ArrayList<>();

    // 백트래킹 사용
    // 사용 예시 : combination(arr, visited, 0, n, r)
    static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            print(arr, visited, n);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    // 배열 출력
    static void print(int[] arr, boolean[] visited, int n) {
        int[] tmp = new int[2];
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                if(tmp[0] == 0) {
                    tmp[0] = arr[i];
                } else {
                    tmp[1] = arr[i];
                }
            }
        }
        combResultList.add(tmp);
    }

}

class Solution44 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result44.nonDivisibleSubset(k, s);

        bufferedReader.close();
    }
}
