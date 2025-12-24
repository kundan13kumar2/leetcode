package sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HeapSort {
    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] arr = {10, 5, 15, 2, 20, 30};
        HeapSort hs = new HeapSort();

        for (int i = (arr.length-1)/2; i >= 0; i--) {
            hs.minHeapify(arr, i, arr.length);
        }

        System.out.println(Arrays.toString(arr));

    }

    public void minHeapify(int[] arr, int i, int n) {
        int smallest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] < arr[smallest]) {
            smallest = l;
        }

        if (r < n && arr[r] < arr[smallest]) {
            smallest = r;
        }

        if (smallest != i) {
            int temp =  arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            minHeapify(arr, smallest, n);
        }
    }
}
