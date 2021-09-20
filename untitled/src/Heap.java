public class Heap {
    private int size = 6;
    int[] maxHeap = new int[3];

    private void swap(int a, int b) {
        int temp = maxHeap[a];
        maxHeap[a] = maxHeap[b];
        maxHeap[b] = temp;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos);
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        return pos >= (size / 2) && pos <= size;
    }

    // 데이터 삽입 시 바로 힙의 조건 판단 후 스왑
    public void insert(int input) {
        maxHeap[++size] = input;
        int current = size;
        while(maxHeap[current] > maxHeap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }
    // 힙 삭제 시 재조정을 위한 재귀함수
    private void maxHeapify(int pos) {
        if (isLeaf(pos)) {
            return;
        }
        if (maxHeap[pos] < maxHeap[leftChild(pos)]
                || maxHeap[pos] < maxHeap[rightChild(pos)]) {
            if(maxHeap[leftChild(pos)] > maxHeap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            } else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }
}
