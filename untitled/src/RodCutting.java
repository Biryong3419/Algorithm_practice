import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RodCutting {
    /*
    - DP 문제 -
    Rod Cutting(막대 자르기) Problem
    길이가 N인 막대 존재. 길이가 자연수가 되도록 여러 조각으로 자룰 수 있음
    자르는 기링에 따라 막대기의 값이 정해져 있음.
    막대를 자르는 값어치의 합이 최대가 되게끔 막대기를 잘라야 한다.

    e.g, 길이가 4인 막대기를 자를 때, 길이 별 받을 수 있는 값은 아래와 같다.
    Length 1 2 3 4
    Cost   1 5 8 9
    이 경우에 길이 2에 cost 5인 막대기 두 개가 되게끔 자르면 전체 값어치가 10으로 최대로 값을 받을 수 있을 것이다.

    첫 줄에 막대기 길이 N(1 <= N <= 3000)이 주어지고,
    두번째 줄에 1000이하의 자연수 N개가 공백으로 구분되어 주어진다. i번째 자연수는 길이 i 막대기의 값을 의미한다.

    -> 첫 줄에 값어치 합이 최대가 되도록 막대기를 자를 때, 합을 출력한다.
    예제 입력 :
    4
    1 5 8 9

    예제 출력 : 10
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> intList = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int[] nArr = new int[n +1];
        for(int i = 0; i < n; i ++) {
            nArr[i+1] = intList.get(i);
        }
        int[] maxArr = new int[n +1];
        for(int i = 1; i <= n ; i++){
            int max = 0;
            for(int j = 0; j <= i; j++) {
                max = Math.max(max, nArr[j] + maxArr[i-j]);
            }
            maxArr[i] = max;
            System.out.println(Arrays.toString(maxArr));
        }
        System.out.println(maxArr[n]);
    }
}
