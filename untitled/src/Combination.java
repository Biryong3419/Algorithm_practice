public class Combination {
    /*
    조합 : n개의 숫자 중에서 r개의 수를 순서 없이 뽑는 경우
    순열은 1,2,3 / 1,3,2 / 2,1,3 모두 다른 결과를 가져오나, 조합에서는 모두 같은 것으로 취급 한다.(순서가 상관 없기 때문에)
    기호 : nCr == n-1Cr-1 + n-1Cr
     */

    // 참고사이트 : https://minhamina.tistory.com/38
    public static void main(String[] args) {
        System.out.println(combination(3, 2)); // 3개 중에서 2개를 뽑는 조합의 경우의 수

        int[] arr = {1, 2, 3};
        boolean[] visited = new boolean[arr.length]; // 조합에 뽑혔는지를 확인하기 위한 배열

        // 1. 백트래킹을 이용해 구현
        for(int r = 1; r <= arr.length; r++) { //반복문을 통해 1개부터 배열의 크기 까지 r개를 뽑는다
            comb1(arr, visited, 0, r);
        }

        // 2. 재귀를 이용해 구현
        for(int r = 1; r <= arr.length; r++) {
            comb2(arr, visited, 0, r);
        }
    }
    //1. 백트래킹을 이용해 구현
    static void comb1(int[] arr, boolean[] visited, int start, int r) {
        if(r == 0) {
            print(arr, visited);
            return;
        } else {
            for(int i = start; i < arr.length; i++) {
                visited[i] = true;
                comb1(arr, visited, i + 1, r - 1);
                visited[i] = false;
            }
        }
    }

    //2. 재귀를 이용해 구현
    static void comb2(int[] arr, boolean[] visited, int depth, int r) {
        if(r == 0) {
            print(arr, visited);
            return;
        }
        if(depth == arr.length) {
            return;
        } else {
            visited[depth] = true;
            comb2(arr, visited, depth + 1, r - 1);

            visited[depth] = false;
            comb2(arr, visited, depth + 1, r);
        }
    }

    // 배열 출력
    static void print(int[] arr, boolean[] visited) {
        for(int i = 0; i < arr.length; i++) {
            if(visited[i] == true)
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static int combination(int n, int r) {
        if(n == r || r == 0) {
            return 1;
        } else {
            return combination(n - 1, n - 1) + combination(n - 1, r);
        }
    }
}
