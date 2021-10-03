import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
class Result555 {
    /*
     * Complete the 'solution' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY startHeight
     *  2. INTEGER_ARRAY descentRate
     */
    static HashMap<Integer, List<Integer>> remainSecAndFlights = new HashMap<>();
    static PriorityQueue<Integer> p = new PriorityQueue<>(); //최소힙

    static int result = 0;
    static int currentSec = 1;
    public static int solution(List<Integer> startHeight, List<Integer> descentRate) {

        // Write your code here


        // 남은시간과 해당 시간에 비행기들

        for(int i = 0; i < startHeight.size(); i ++) {
            int remainSec = getRemainSec(startHeight.get(i), descentRate.get(i));

            // 비어있으면 초기화
            if(!remainSecAndFlights.containsKey(remainSec)) {
                remainSecAndFlights.put(remainSec, new ArrayList<>());
                p.add(remainSec);
            }
            remainSecAndFlights.get(remainSec).add(i);
        }

        while(true) {
            int attackResult = attackFlight(currentSec, 0);
            if(attackResult == -1) {
                break;
            }
            if(remainSecAndFlights.size() == 0) {
                break;
            }
            currentSec++;
        }

        return result;


    }

    public static int attackFlight(int currentSec, int depth) {
        int tmpSec = currentSec + depth;
        //현재 초에 처리해야할 비행기 있으면
        if(remainSecAndFlights.containsKey(tmpSec)) {
            List<Integer> flights = remainSecAndFlights.get(tmpSec);

            // 처리해야할 비행기 2개 이상이면, 한개 처리하고 게임 종료
            if(flights.size() > 1) {
                result++;
                if(depth == 0) {
                    return -1;
                } else {
                    remainSecAndFlights.get(tmpSec).remove(0);
                    return 0;
                }
            }

            if(flights.size() == 1) {// 비행기 1개면
                result++;
                p.poll();
                remainSecAndFlights.remove(tmpSec);
                return 0;
            }

            if(remainSecAndFlights.size() == 0) {
                // 처리할 비행기 없으면 종료
                return -1;
            }
            return 0;
        } else { // 없으면 다음꺼 아무거나 하나 처리
            return attackFlight(currentSec, p.peek() - currentSec);
        }

    }

    public static int getRemainSec(int height, int desentRate) {
        if(height % desentRate > 0) {
            return height / desentRate + 1;
        } else {
            return height / desentRate;
        }
    }


}
class Solution555 {
    static Random random = new Random();
    public static int getRandomNumberUsingNextInt(int min, int max) {
        return random.nextInt(max - min) + min;
    }
    public static void main(String[] args) throws IOException {
        List<Integer> startHeight = new ArrayList<>();
        List<Integer> desentRate = new ArrayList<>();

        for(int i = 1; i <= 10*10*10*10*10; i++) {
            startHeight.add(getRandomNumberUsingNextInt(1000000, 100000000));
            desentRate.add(getRandomNumberUsingNextInt(1, 5));
        }
        System.out.println(startHeight.size() + "," + desentRate.size());

        int result = Result555.solution(startHeight, desentRate);
        System.out.println(result);
    }
}