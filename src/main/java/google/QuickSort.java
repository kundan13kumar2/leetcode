package google;

import java.util.Arrays;

public class QuickSort {

    private int partition(int[] arr, int l, int h) {

        int pivot = arr[h];

        int i = l, j = l;

        for (; i < h; i++) {
            if (arr[i] < pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        int temp = arr[j];
        arr[j] = arr[h];
        arr[h] = temp;
        return j;
    }


    private void quickSort(int[] arr, int l, int h) {

        if (l < h) {
            int pIdx = partition(arr, l, h);
            quickSort(arr, l, pIdx - 1);
            quickSort(arr, pIdx + 1, h);
        }
    }


    public static void main(String[] args) {
        int[] arr = {64, 12, 25, 22, 15};

        QuickSort sort = new QuickSort();
        sort.quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
