import java.util.Arrays;

public class Permutation {
    /*
    #순열
    - 서로 다른 N개의 원소에서 R개를 중복없이 골라 순서에 상관있게 나열하는 것
    nPr 로 표현(N개에서 r개를 뽑는다.)
    - 5P3 = 5*4*3
     */


    public static void main(String[] args) {
        int[] arr = {0, 1, 2}; // 순열을 만들 배열
        int n = arr.length; // 배열의 길이
        int[] output = new int[n]; // 순열 출력을 위한 배열
        boolean[] visited = new boolean[n]; // 중복해서 뽑지 않기 위해 방문했는지를 체크하는 배열

        //1. Swap함수를 이용해 구현
        //per1(arr, 0, n , 3);

        //2. DFS를 이용해 구현
        per2(arr, output, visited, 0, n ,3); //r = 3, 3개를 뽑을 것
    }

    static void per2(int[] arr, int[] output, boolean[] visited, int depth, int n, int r){
        if(depth == r) {
            System.out.println(Arrays.toString(output) + "," + r);
            return;
        }
        for(int i = 0; i < n; i++) {
            if(visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i]; // depth마다 i 번째 수 넣어준다.
                per2(arr, output, visited, depth + 1, n, r); // depth + 1 해서 recursive 시킨다
                visited[i] = false;
            }
        }
    }

    static void per1(int[] arr, int depth, int n, int r) {
        if(depth == r) {
            System.out.println("[result]" + Arrays.toString(arr) + "," + r);
            return;
        }
        for(int i = depth; i < n; i++) {
            System.out.println("depth:" + depth + "  i:" + i + "  arr:" + Arrays.toString(arr));
            swap(arr, depth, i);
            per1(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }
     static void swap(int[] arr, int depth, int i) { // 두 배열의 값을 바꾸는 swap 함수
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
     }
}
