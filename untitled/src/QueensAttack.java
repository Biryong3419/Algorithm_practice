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

class Result {

    /*
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER r_q
     *  4. INTEGER c_q
     *  5. 2D_INTEGER_ARRAY obstacles
     */

    static int[][] arr = null;
    static Map<String, String> obstacleMap= new HashMap<>();
    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        // Write your code here
        //initialize
        arr = new int[n][n];

        for(List<Integer> obstacle : obstacles) {
            //arr[obstacle.get(0)-1][obstacle.get(1)-1] = 1;
            obstacleMap.put((obstacle.get(0)-1) + "-" + (obstacle.get(1)-1), "obstacle");
        }
        arr[r_q-1][c_q-1] = 2;

        int result = 0;
        result += findEnd(1,0, c_q-1, r_q-1, 0);
        result += findEnd(1,1, c_q-1, r_q-1, 0);
        result += findEnd(0,1, c_q-1, r_q-1, 0);
        result += findEnd(-1,1, c_q-1, r_q-1, 0);
        result += findEnd(1,-1, c_q-1, r_q-1, 0);
        result += findEnd(-1,0, c_q-1, r_q-1, 0);
        result += findEnd(0,-1, c_q-1, r_q-1, 0);
        result += findEnd(-1,-1, c_q-1, r_q-1, 0);

        return result;
    }
    static int findEnd(int x, int y, int cx, int cy, int cdepth) {
        int currentx = cx+x;
        int currenty = cy+y;
        if(currentx < 0 || currentx>= arr.length || currenty < 0 ||  currenty >= arr.length) {
            return cdepth;
        }
        if(obstacleMap.containsKey(currenty + "-" + currentx)) {
            return cdepth;
        }
        return findEnd(x,y,currentx,currenty,cdepth+1);
    }

//    static int[][] arr = null;
//    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
//        // Write your code here
//        //initialize
//
//        arr = new int[n][n];
//
//        for(List<Integer> obstacle : obstacles) {
//            arr[obstacle.get(0)-1][obstacle.get(1)-1] = 1;
//        }
//        arr[r_q-1][c_q-1] = 2;
//
//
//        int result = 0;
//        result += findEnd(1,0, c_q-1, r_q-1, 0);
//        result += findEnd(1,1, c_q-1, r_q-1, 0);
//        result += findEnd(0,1, c_q-1, r_q-1, 0);
//        result += findEnd(-1,1, c_q-1, r_q-1, 0);
//        result += findEnd(1,-1, c_q-1, r_q-1, 0);
//        result += findEnd(-1,0, c_q-1, r_q-1, 0);
//        result += findEnd(0,-1, c_q-1, r_q-1, 0);
//        result += findEnd(-1,-1, c_q-1, r_q-1, 0);
//
//        return result;
//
//    }
//    static int findEnd(int x, int y, int cx, int cy, int cdepth) {
//        int currentx = cx+x;
//        int currenty = cy+y;
//        if(currentx < 0 || currentx>= arr.length || currenty < 0 ||  currenty >= arr.length) {
//            return cdepth;
//        }
//        if(1 == arr[currenty][currentx]) {
//            return cdepth;
//        }
//        return findEnd(x,y,currentx,currenty,cdepth+1);
//    }

}


class Solution55 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r_q = Integer.parseInt(secondMultipleInput[0]);

        int c_q = Integer.parseInt(secondMultipleInput[1]);

        List<List<Integer>> obstacles = new ArrayList<>();

        IntStream.range(0, k).forEach(i -> {
            try {
                obstacles.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.queensAttack(n, k, r_q, c_q, obstacles);

        bufferedReader.close();
    }
}