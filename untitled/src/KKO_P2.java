import com.sun.jmx.remote.internal.ArrayQueue;

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
class Result123 {
    /*
     * Complete the 'solution' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER a
     *  3. STRING cards
     */

    public static int solution(int n, int a, String cards) {
        Map<Integer, Character> playerCardMap = new HashMap<>();
        List<Character> cardList = new ArrayList<>();
        char[] chars = cards.toCharArray();
        for(int i=0; i<cards.length(); i++) {
            cardList.add(chars[i]);
        }
        List<Integer> pList = new ArrayList<>();
        //처음 조르디카드 null
        cardList.add(a, '0');
        for(int i=0; i< n; i++) {
            if(i == a) {
                // 죠르디 초기카드
                if(a % 2 == 0) {
                    // 짝수면
                    // 다음상대 있으면 넣고, 없으면 '0' 유지
                    if(i+1 < n) {
                        char afterCard = cardList.get(i+1);
                        playerCardMap.put(i, getNextCard(afterCard));
                    } else {
                        playerCardMap.put(i, '0');
                    }

                } else {
                    // 홀수면 이전상대와 비교
                    char beforeCard = cardList.get(i-1);
                    playerCardMap.put(i, getNextCard(beforeCard));
                }
            } else {
                playerCardMap.put(i, cardList.get(i));
            }
            pList.add(i);
        }
        System.out.println("cardList =>" + cardList);

        System.out.println("cardMap =>" + playerCardMap);


        int totalRound = (int) Math.ceil(Math.sqrt(n));
        System.out.println("totalRound => " + totalRound);

        int changeCount = 0;
        while(totalRound > 0) {
            List<Integer> newPlist = new ArrayList<>(pList);
            int offset = 0;
            for(int i = 0; i < pList.size(); i ++) {
                if(i%2 == 0) {
                    // 0or짝수면 다음상대와 겨룬다
                    int zordi = -1;
                    boolean isZordiBefore = false;

                    boolean isZordiAfter = false;
                    char beforeCard = playerCardMap.get(i);

                    if(i == a) {
                        zordi = i;
                        isZordiBefore = true;
                    }

                    // 대결카드 다음에 있으므로 대결하고 리스트줄여줌
                    if(i + 1 < pList.size()) {
                        char afterCard = playerCardMap.get(i+1);
                        if(i+1 == a) {
                            zordi = i+1;
                            isZordiAfter = true;
                        }

                        // 죠르디 있음
                        if(zordi != -1) {
                            if(playerCardMap.get(zordi) == '0') {
                                if(isZordiBefore) {
                                    changeCount++;
                                    beforeCard = getNextCard(afterCard);
                                }
                                if(isZordiAfter) {
                                    changeCount++;
                                    afterCard = getNextCard(beforeCard);
                                }
                            } else {
                                if(isZordiAfter) {
                                    if(isWin(beforeCard,playerCardMap.get(i+1)) != 2) {
                                        afterCard = getNextCard(beforeCard);
                                        changeCount++;
                                    }
                                }
                                if(isZordiBefore) {
                                    if(isWin(playerCardMap.get(i), afterCard) != 1) {
                                        beforeCard = getNextCard(afterCard);
                                        changeCount++;
                                    }
                                }
                            }
                        }

                        int result = isWin(beforeCard, afterCard);

                        // 결과처리
                        if(result == 1) {
                            newPlist.remove(i+1-offset);
                            offset++;
                        }
                        if(result == 2) {
                            newPlist.remove(i-offset);
                            offset++;
                        } else {
                            newPlist.remove(i-offset);
                            offset++;
                            newPlist.remove(i-offset);
                            offset++;
                        }

                    } else {
                        //다음상대없으면 암것도 안함
                    }

                }
                // 한칸 건너띈다.
                i++;
            }
            pList = new ArrayList<>(newPlist);

            totalRound--;
        }
        System.out.println("changeCount => " + changeCount);


        return -1;
    }
    public static char getNextCard(char to){
        if(to == 'R'){
            return 'P';
        }else if (to == 'P'){
            return 'S';
        } else if(to == 'S'){
            return 'R';
        }
        return '0';
    }
    public static int isWin(char from, char to){
        //1 from win
        //2 to win
        //3 all death
        if(from == to){
            return 3;
        }
        if(from == 'P' && to == 'R'){
            return 1;
        }else if(from == 'R' && to == 'P'){
            return 2;
        }else if (from =='S' && to == 'P'){
            return 1;
        }else if (from =='P' && to == 'S'){
            return 2;
        }else if (from == 'R' && to == 'S'){
            return 1;
        }else if(from =='S' && to == 'R'){
            return 2;
        }
        return -1;
    }
}
class Solution123 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        int a = Integer.parseInt(bufferedReader.readLine().trim());
        String cards = bufferedReader.readLine();
        int result = Result123.solution(n, a, cards);
        System.out.println("result => " + result);
        bufferedReader.close();
    }
}