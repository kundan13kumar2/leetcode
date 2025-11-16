package daily;

import java.util.Arrays;
import java.util.List;
/*
NOT CORRECT
 */
public class CountInversion {
    int[] result;

    public static void main(String[] args) {
        int[] arr = {5,2,6,1};

        CountInversion countInversion = new CountInversion();
        System.out.println(countInversion.countSmaller(arr));
    }

    public List<Integer> countSmaller(int[] nums) {

        countInversion(nums);

        return Arrays.stream(result).boxed().toList();
    }

    public void countInversion(int[] array) {
        result = new int[array.length];
        divide(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public void divide(int[] arr, int l, int r) {
        if (l < r) {
            int mid = (r + l) / 2;

            divide(arr, l, mid);
            divide(arr, mid + 1, r);

            conquer(arr, l, mid, r);
        }

    }

    public void conquer(int[] array, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < n1; i++) {
            left[i] = array[l + i];
        }
        System.out.println(Arrays.toString(left));

        for (int i = 0; i < n2; i++) {
            right[i] = array[mid + 1 + i];
        }
        System.out.println(Arrays.toString(right));

        int k = l;
        int i = 0, j = 0;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                // array[k++] = left[i++];
                i++;
            } else {
                //array[k++] = right[j++];
                j++;
                int t = mid;
                System.out.println(Arrays.toString(left));
                System.out.println(Arrays.toString(right));
                while (t >= l) {
                    System.out.println(array[t] +" "+array[mid+j]);
                    if (array[t] >= array[mid+j])
                        result[t]++;
                    t--;
                }
                System.out.println(Arrays.toString(result));
                System.out.println("______________________");
            }
        }

//        while (i < n1) {
//            array[k++] = left[i++];
//        }
//        while (j < n2) {
//            array[k++] = right[j++];
//        }

    }


}
