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

class Result55 {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here

        Set<Integer> scoreSet = new HashSet<>();
        for (int i = 0; i < ranked.size(); i++) {
            scoreSet.add(ranked.get(i));
        }

        List<Integer> scoreList = new ArrayList<>(scoreSet);
//내림차순 정렬
        Collections.sort(scoreList);
        Collections.reverse(scoreList);

        System.out.println(scoreList);
        List<Integer> resultList = new ArrayList<>();

        int i = scoreList.size();
        int currentPlayerCursor = 0;
        while(true) {
            int currentPscore = player.get(currentPlayerCursor);
            int currentRscore = scoreList.get(i-1);

            if(currentPscore > currentRscore) {
                int rst= findNextIdx(scoreList, i, currentPscore);
                if(rst == -1) {
                    resultList.add(i);
                    currentPlayerCursor += 1;
                    if(i > 1) {
                        i --;
                    }
                } else {
                    resultList.add(rst);
                    i = rst;
                    currentPlayerCursor += 1;
                }


            } else if(currentPscore == currentRscore) {
                resultList.add(i);
                currentPlayerCursor += 1;

            } else {
                resultList.add(i + 1);
                currentPlayerCursor += 1;
            }
            if(currentPlayerCursor == player.size()) {
                break;
            }
        }
        System.out.println(resultList);
        return resultList;
    }
    public static int findNextIdx(List<Integer> filteredRanks, int cIdx, int cPscore) {
        if(cIdx==0) {
            return cIdx + 1;
        }
        if(cPscore > filteredRanks.get(cIdx-1)) {
            return findNextIdx(filteredRanks, cIdx-1, cPscore);
        }else if(cPscore == filteredRanks.get(cIdx-1)) {
            return cIdx;
        }else {
            return cIdx+1;
        }
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result55.climbingLeaderboard(ranked, player);

        bufferedReader.close();
    }
}
