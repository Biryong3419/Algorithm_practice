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

class Result2 {

    /*
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */

    public static int formingMagicSquare(List<List<Integer>> s) {
        // Write your code here
        int sideLength = s.size();

        Map<Integer, Integer> myMap = new HashMap<>();
        // initialize (숫자 쭉 나열한다.)
        for(int i = 1; i <= sideLength * sideLength; i++) {
            myMap.put(i, 0);
        }

        for(List<Integer> row: s) {
            for(int col: row) {
                myMap.put(col, myMap.get(col)+1);
            }
        }
        System.out.println("before => " + myMap);

        int resultSum = 0;

        for(int i = 1; i <= sideLength * sideLength; i++) {
            int value = myMap.get(i);
            if(value == 0) {
                int offset = 1;
                while(true){
                    int foundedIdx = findClosedMoreOne(myMap, i, offset);
                    if(foundedIdx != -1) {
                        resultSum += Math.abs(foundedIdx - i);
                        myMap.put(i, 1);
                        myMap.put(foundedIdx, myMap.get(foundedIdx) - 1);
                        break;
                    } else {
                        offset++;
                    }
                }
            } else if(value > 1) {
                int offset = 1;
                while(true){
                    int foundedIdx = findClosedZero(myMap, i, offset);
                    if(foundedIdx != -1) {
                        resultSum += Math.abs(foundedIdx - i);
                        myMap.put(foundedIdx, 1);
                        myMap.put(i, myMap.get(i) - 1);
                        break;
                    } else {
                        offset++;
                    }
                }
            }
        }

        System.out.println("after => " + myMap);
        System.out.println(resultSum);

        return resultSum;

    }
    public static int findClosedMoreOne(Map<Integer, Integer> map, int idx, int offset) {
        Integer result = map.get(idx - offset);
        if(result != null && result > 1) {
            return idx - offset;
        }
        Integer result2 = map.get(idx + offset);
        if(result2 != null && result2 > 1) {
            return idx + offset;
        }

        return -1;
    }

    public static int findClosedZero(Map<Integer, Integer> map, int idx, int offset) {
        Integer result = map.get(idx - offset);
        if(result != null && result == 0) {
            return idx - offset;
        }
        Integer result2 = map.get(idx + offset);
        if(result2 != null && result2 == 0) {
            return idx + offset;
        }

        return -1;
    }

}

class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> s = new ArrayList<>();

        IntStream.range(0, 3).forEach(i -> {
            try {
                s.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result2.formingMagicSquare(s);

        bufferedReader.close();
    }
}
