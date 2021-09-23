/*
시간복잡도
평균 : nlog(n)
최악 : O(n^2)
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = { 80, 70, 60, 50, 40, 30, 20 };
        quicksort(array, 0, array.length - 1);
        for (int v : array) {
            System.out.println(v);
        }
    }
    public static int partition(int[] array, int left, int right) {
        int mid = (left + right) / 2;

        int pivot = array[mid];

        while (left <= right) {
            while (array[left] < pivot) {
                left++;
            }

            while (array[right] > pivot) {
                right--;
            }

            if(left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    public static void swap(int[] array, int a, int b) {
        int temp = array[b];
        array[b] = array[a];
        array[a] = temp;
    }

    public static void quicksort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int pi = partition(array, left, right);

        if(left < pi-1) quicksort(array, left, pi - 1);
        if(right > pi) quicksort(array, pi, right);
    }
}
