public class YNJ_T1 {
}
class Solution12344 {
    public int solution(String G) {
        // write your code in Java SE 8

        //0 rock
        //1 sisor
        //2 paper

        int max = 0;
        for(int i = 0; i < 3; i ++) {
            int tmpScore = 0;
            for(char c : G.toCharArray()) {
                tmpScore += getResult(i, convert(c));
            }
            if(max < tmpScore) {
                max = tmpScore;
            }
        }
        return max;
    }
    public int convert(char input) {
        if(input == 'R') {
            return 0;
        }else if(input == 'S') {
            return 1;
        } else if(input == 'P') {
            return 2;
        }
        return -1;
    }

    public int getResult(int user, int other) {
        if(user == 0 && other == 0) {
            return 1;
        } else if(user == 0 && other == 1) {
            return 2;
        } else if(user == 0 && other == 2) {
            return 0;
        } else if(user == 1 && other == 0) {
            return 0;
        } else if(user == 1 && other == 1) {
            return 1;
        } else if(user == 1 && other == 2) {
            return 2;
        } else if(user == 2 && other == 0) {
            return 2;
        }else if(user == 2 && other == 1) {
            return 0;
        }else if(user == 2 && other == 2) {
            return 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution12344 s = new Solution12344();
        s.solution("RSPRS");
    }
}
